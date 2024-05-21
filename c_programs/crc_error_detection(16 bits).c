//CRC- 16 bits;

//Here length of data(k) = 4
//Length of transimission data(n) = 19
//Length of divisor = 16
//Divisor = ""

#include<stdio.h>
#include <string.h>
#include<stdbool.h>>
char divisor[] = "1000100000010001";
char divident[] = "0000000000000000000"; //19 bits;
int n = 19, k = 4;

char* bitwiseDivision(char divident[]);
char* encapsulate(char data[]);

int main()
{
	char data[k];
	char recieved_data[n];

	printf("Enter 4 bit data: ");
	scanf("%s", &data);

	//printf("%s\n", data);
	
	char* transmission_data_ptr = encapsulate(data);
	
	char encapsulated_data[n+1];
	
	for(int i=0; i<n; i++){
		encapsulated_data[i] = *(transmission_data_ptr+i);
	}
	encapsulated_data[n] = '\0';
	
	printf("CRC data is: 	%s\n", encapsulated_data);
	
	printf("\n\n");
	
	printf("Enter  19 bit data as recieved site: ");
	scanf("%s", &recieved_data);
	
	char* recieved_data_ctc_ptr = bitwiseDivision(recieved_data);
	char recieved_data_ctc[n];
	
	for(int i=0; i<n; i++){
		recieved_data_ctc[i] = *(recieved_data_ctc_ptr+i);
	}
	
	bool is_one_present = false;
	
	for(int i=0; i<n; i++){
		if(recieved_data_ctc[i] == '1'){
			is_one_present = true;
			break;
		}
	}
	
	if(is_one_present){
		printf("\n\n********************Error in recieved data***************************\n\n");
	}
	else{	
		printf("\n\n********************recieved data is error free!!!!***************************\n\n");
	}
	
	printf("Remiande: 	%s", recieved_data_ctc);
	
}

char* encapsulate(char data[])
{
	
	for(int i=0; i<k; i++){
		divident[i] = data[i];
	}
	
	char* remainder = bitwiseDivision(divident);
	
	printf("\n\n");
		
	int encapsulated_ptr = -1;
	
	for(int i=0; i<n; i++){
		if(*(remainder+i) == '1'){
			encapsulated_ptr = i;
			break;
		}
	}
	
	for(int i=0; i<encapsulated_ptr; i++){
		divident[i] = data[i];
	}
	
	
	return divident;
	
}

char* bitwiseDivision(char divident[])
{
	int ptr = 0;
	
	//printf("%s\n", divident);
	
	while(ptr+16 <= n){
		
		for(int i=ptr; i<ptr+16; i++){
			if(divisor[i-ptr] == divident[i]){
				divident[i] = '0';
			}
			else{
				divident[i] = '1';
			}
		}
			
		while(ptr < n)
		{
			if(divident[ptr] == '1')
			{
				break;
			}
			ptr++;
		}		
			
	}
	
	return divident;
}

























