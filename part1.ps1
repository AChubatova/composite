import sys, arcgisscripting
gp = arcgisscripting.create(9.3)
print gp.setproduct(sys.argv[1])

