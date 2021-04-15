FOR /l %%X IN (1,1,100) DO (
 echo %%X
 ping -n 10 127.0.0.1 >NUL )
