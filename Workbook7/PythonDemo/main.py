# variables are declared without specifying a type
name = "Gregor"

# this is a function definition
def greet(name):
    print("Hello " + name)
    

greet(name)

age = 15

# if statements use elif instead of else if
if age > 65:
    print("You should think about retiring")
elif age > 40:
    print("man you are getting close")
else:
    print("you got time")
