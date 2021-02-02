import sys, arcgisscripting
gp = arcgisscripting.create(9.4)
print gp.setproduct(sys.argv[1])
