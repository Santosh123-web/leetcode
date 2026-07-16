// Last updated: 7/16/2026, 4:10:34 PM
class Solution {
    public void rotate(int[][] matrix) {
        int[][] arr=new int[matrix.length][matrix.length];
        int a=0,b=0;
        for(int i=matrix.length-1;i>=0;i--){
            b=0;
            for(int j=0;j<matrix.length;j++){
                arr[b++][a]=matrix[i][j];
            }
            a++;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix[i][j]=arr[i][j];
            }
        }
    }
}