
public class FindBiggest {
	
	public int[] values;
	public int biggest;
	
	public FindBiggest(int...values){
		this.values=values;
		biggest = values[values.length-1];
	}
	
	public int findBiggest(){
		for(int i=0;i<values.length-1;i++){
			for(int j=i;j<values.length-1;j++){
				int tmp = values[i];
				if(values[j]<values[i]){
					values[i] = values[j];
					values[j]=tmp;
				}
			}
		}
		return values[values.length-2];
	}
	

}
