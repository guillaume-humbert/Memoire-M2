# The decorator function.
def log(fn):

	# The wrapped function.
	def wrap(*args, **kwargs):
		print("Entering '" + fn.__name__ + "'.")

		# Arguments logging.
		s = "Arguments: "
		for a in args:
			s = s + str(a) + ", "
		for k in kwargs.keys():
			s = s + k + ": " + str(kwargs[k]) + ", "
		print(s[:-2])

		# The real function is executed.
		res = fn(*args, **kwargs)

		print("Leaving '" + fn.__name__ + "'.")
		print("Return value: " + str(res))
		return res
	
	return wrap

@log
def add(x, y):
	return x + y

print("Result = " + str(add(2 ,3)))

