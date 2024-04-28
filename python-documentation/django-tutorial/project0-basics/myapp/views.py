from django.shortcuts import render
from django.http import HttpResponse

#***************To illustrate, sending data from view to html file
# def index(request):
#    context = {
#       'name': 'Darshith L',
#       'age': 21,
#       'nationality': 'Indian'
#    }
#    #return render(request, 'index.html', {'name': 'darshith'})
#    return render(request, 'index.html', context)

#*************To illustrate, accepting data from one html page and processing it, sending output to other page

# def index(request):
#    return render(request, 'index.html')

# def counter(request):
#    text = request.GET['text']
#    return render(request, 'counter_page.html', {'word_count': len(text.split())})

#*************To illustrate, accepting data from one html page and processing it, sending output to same page

# def index(request):
#    return render(request, 'index.html')

# def counter(request):
#    text = request.POST['text']
#    return render(request, 'index.html', {'word_count': len(text.split())})

#************To illustrate how django recognizes static files like css, js, images etc
def index(request):
   return render(request, 'index.html')


 
