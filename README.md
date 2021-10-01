This is a java swing gui program that calculates gpa after receiving mandatory inputs such as
	-The user name;
	-The Mat number;
	-Semester;
	-course title;(optional)
	-course's credit value;
	-course's marks /100;
	
its display the various grades relative to the marks and calculates the gpa.
This code was built in netbeans

select lib1,mnt1,mnt2 from (with e as ( select lib1, sum(mnt1)as mnt1 from scinv where lib6 not like :chap group by lib1), a as (select lib1, sum(mnt1)as mnt2 from scinv where lib6 like :chap group by lib1) select e.lib1, e.mnt1 , a.mnt2 from e,a  where (e.mnt1 != 0 or  a.mnt2 != 0))r;
