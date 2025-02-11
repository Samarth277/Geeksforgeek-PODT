//6-feb //

class Solution
{
    long ans=0;
    Node tar;
    long verticallyDownBST(Node root,int target)
    {
        //s1 - search the target node in bst
        while(root!=null)
        {
            if(root.data < target) 
            {
                root=  root.right;
            }
            else if(root.data > target)
            {
                root = root.left;
            }
            else //==
            break;
        }
        if(root==null)
        return -1;
        
        tar = root;
        inorder(tar, 0);
        return ans;
        
    }
    void inorder(Node node, int dir)
    {
       if(node!=null)
       {
           inorder(node.left, dir-1);
           inorder(node.right, dir+1);
           if(node!=tar && dir==0)
           ans+=node.data;
       }
    }
}
