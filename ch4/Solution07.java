package codingbootcamp;

import java.util.*;

class Project {
	String name;
	int in_degree; // this node depend on how many nodes
	ArrayList <Project> depend; // nodes who depend on this node
	
	Project(String a, int in, ArrayList <Project> d) {
		name = a;
		in_degree = in;
		depend = d;
	}
}

public class codingbootcamp {
	public ArrayList<String> buildOrder(ArrayList<Project> pro) {
		LinkedList <Project> ls = new LinkedList <Project> ();
		for (Project x : pro) {
			if (x.in_degree == 0) ls.push(x);
		}
		
		ArrayList <String> ans = new ArrayList <String> ();
		Project now;
		while (!ls.isEmpty()) {
			now = ls.poll();
			ans.add(now.name);
			if (now.depend != null) {
				for (Project x : now.depend) {
					x.in_degree --;
					if (x.in_degree == 0) ls.add(x);
				}
			}
		}
		if (ans.size() == pro.size()) return ans;
		else return null;
	}
	
	public static void main(String[] args) {
		ArrayList <Project> pro = new ArrayList <Project> ();
		
		Project cc = new Project("c", 1, null);
		pro.add(cc);
		
		ArrayList <Project> d = new ArrayList <Project> ();
		d.add(cc);
		Project dd = new Project("d", 2, d);
		pro.add(dd);
		
		ArrayList <Project> a = new ArrayList <Project> ();
		a.add(dd);
		Project aa = new Project("a", 1, a);
		pro.add(aa);
		
		ArrayList <Project> b = new ArrayList <Project> ();
		b.add(dd);
		Project bb = new Project("b", 1, b);
		pro.add(bb);
		
		pro.add(new Project("e", 0, null));
		
		ArrayList <Project> f = new ArrayList <Project> ();
		f.add(aa); f.add(bb);
		pro.add(new Project("f", 0, f));
		
		System.out.println(new codingbootcamp().buildOrder(pro));
    }
}