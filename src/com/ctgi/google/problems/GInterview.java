package com.ctgi.google.problems;
I am hereCan you see me typing?

Given a binary search tree of ints, and a min and a max int, find the sum of those nodes in the tree whose values fall between the min and the max.

       8
      /  \
     /     \ 
   6     11
  /  \     /  \
4    7  9   14

min: 6, max : 9, 6 + 7 + 8 + 9

public int findNodesSumBetweenMinAndMax(TreeNode root, int min, int max)
{
if(root==null)
{
return 0;
}
int value=root.data;
if(min<=value && value<=max)
{
    return value+ findNodesSumBetweenMinAndMax(root.left, min, max) + findNodesSumBetweenMinAndMax(root.right, min, max);
}else if(value < min)
{
        return findNodesSumBetweenMinAndMax(root.right, min, max);
}
else {
    return findNodesSumBetweenMinAndMax(root.left, min, max);
}
// fidnNodesSumBetweenMInAndMax must return an int
}

Given a 2-dimensional array of ints representing a bitmap, and an (x, y) coordinate of a ÒpixelÓ in that bitmap, find the perimeter of the region connected to that pixel that shares the same color.

0001
0100
0110
0000  (1, 1)

4445
4544
4554
4444

...X
.X..
.XX.
....  (1, 1)

public int checkColorCoOrdinates(int[][] colors, int x, int y, int count)
{
    if(x<0 || x >= colors.length || y<0 || y >= colors[0])
    {
return 0;
    }

    int value= colors[x][y];
    //Top
        if( (x-1>=0) && (colors[x-1][y]==value) )
        {
            return checkColorCoOrdinates(colors, x+1,y, count);

        }else if(   (y-1>=0) && (colors[1][y-1]==value) ) //left
        {
            return checkColorCoOrdinates(colors, x,y-1, count+1);
        }
}
