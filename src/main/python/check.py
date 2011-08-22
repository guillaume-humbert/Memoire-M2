def check_age(age):
	if age <= 0:
		raise Exception("Invalid age.")

try:
	check_age(0)
except Exception as e:
	print(e)
else:
	print("ok")


