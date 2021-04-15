FOR /l %%X IN (1,1,100) DO (
 echo %%X
 ping -n 10 localhost > NUL )
