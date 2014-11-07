package com.ctgi.google;



class Node {
   int id;
   int parentId;
   int weight;

   Node(int id, int parentId, int weight){
      this.id = id;
      this.parentId = parentId;
      this.weight = weight;
}
}