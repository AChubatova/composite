import sys, arcgisscripting
gp = arcgisscripting.create(9.2)
print gp.setproduct(sys.argv[1])
