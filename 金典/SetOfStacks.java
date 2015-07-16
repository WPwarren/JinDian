package JinDian;

import java.util.ArrayList;

public class SetOfStacks {
	public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		ArrayList<ArrayList<Integer>> stacks = new ArrayList<ArrayList<Integer>>();
		if(ope == null || ope.length ==0)
			return stacks;
		
		int length = ope.length;
		ArrayList<Integer> cur = null;
		
		for(int i=0;i<length;i++){
			if(ope[i][0] == 1){
				if(cur == null || cur.size() >= size){
					cur = new ArrayList<Integer>();
					stacks.add(cur);
					cur.add(ope[i][1]);
				}else{
					cur.add(ope[i][1]);
				}
			}else if(ope[i][0] == 2){
				if(cur.size() <= 0){
					stacks.remove(stacks.size() - 1);
					cur = stacks.get(stacks.size() - 1);
					cur.remove(cur.size() - 1);
				}else{
					cur.remove(cur.size() - 1);
				}
			}
		}
		
		return stacks;
	}
	public static void main(String[] args) {
		int[][] ope = {{1,97868},{1,69995},{1,28525},{1,72341},
		               {1,86916},{1,5966},{2,58473},{2,93399},{1,84955}
		            ,{1,16420},{1,96091},{1,45179},{1,59472},{1,49594},
		            {1,67060},{1,25466},{1,50357},{1,83509},{1,39489},
		            {2,51884},{1,34140},{1,8981},{1,50722},{1,65104},{1,61130}
		            ,{1,92187},{2,2191},{1,2908},{1,63673},{2,92805},{1,29442}};
		
		System.out.print(setOfStacks(ope, 2));
	}

}
