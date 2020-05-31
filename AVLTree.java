import java.util.*;
class AVL{

  private class Node{
    int data;
    Node left;
    Node right;
    int height;
    Node(int d){
      data=d;
      left=null;
      right=null;
      height =1; //Need to be one to maitain balance facotr
    }
  }
    private Node root;

    public void insert(int item){
      this.root = insert(this.root,item);
    }
    private Node insert(Node root,int item){
        if(root==null){
           root=new Node(item);
           return root;
        }
        if(item>root.data)
          root.right= insert(root.right,item);
        else if(item<root.data)
          root.left = insert(root.left,item);

        root.height = Math.max(height(root.left),height(root.right))+1;
        int bf=bf(root);
        //LLCase
        if(bf>1 && item<root.left.data){
          return rightRotate(root);
        }
        //RR case
        if(bf<-1 && item>root.right.data){
          return leftRotate(root);
        }
        //LR case
        if(bf>1 && item>root.left.data){
           root.left =leftRotate(root.left);

            return rightRotate(root);
        }
        //RL case
        if(bf<-1 && item<root.right.data){
              root.right = rightRotate(root.right);
              return leftRotate(root);
        }
        return root;

    }

  private int bf(Node node){
    if(node==null)
      return 0;
    return height(node.left)-height(node.right);
  }
   private int height(Node c){
     if(c==null){
       return 0;
     }
     return c.height;
   }
    private Node rightRotate(Node c){
        Node b = c.left;
        Node t3 = b.right;

        //Rotate
         b.right =c;
         c.left = t3;

         //Updat height;
         c.height = Math.max(height(c.left),height(c.right))+1;
         b.height = Math.max(height(b.left),height(b.right))+1;


         return b;
    }
    private Node leftRotate(Node c){
        Node b = c.right;
        Node t2 = b.left;

        //Rotate
         b.left =c;
         c.left = t2;

         //Updat height;
         c.height = Math.max(height(c.left),height(c.right))+1;
         b.height = Math.max(height(b.left),height(b.right))+1;


         return b;
    }

    private void display(Node root){
      if(root==null){
        return;
      }
      String str="";
      if(root.left==null){
        str+=".";
      }
      else{
        str+=root.left.data;
      }

      str+="=>"+root.data+"<=";
      if(root.right==null){
        str+=".";
      }
      else{
        str+=root.right.data;
      }
      System.out.println(str);
      display(root.left);
      display(root.right);
    }
    public void display(){
      display(this.root);
    }


}

class AVLTree{
  public static void main(String[] args) {
    AVL a = new AVL();
    a.insert(20);
    a.insert(25);

    a.insert(30);
a.insert(10);
    a.insert(5);

    a.insert(15);
    a.insert(27);
    a.insert(16);
    a.display();




  }
}
