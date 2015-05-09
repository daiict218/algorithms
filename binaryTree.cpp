#include<stdio.h>
#include<algorithm>
#include<stdlib.h>
using namespace std;

struct node
{
	int data;
	struct node *left;
	struct node *right;
};

struct node *newnode(int data)
{
	struct node* node = (struct node *)malloc(sizeof(struct node));
	node->data = data;
	node->left = NULL;
	node->right = NULL;
	return(node);
}

void preOrder(struct node *node)
{
	if(node != NULL)
	{	
		printf("%d ",node->data);
		preOrder(node->left);
		preOrder(node->right);
	}
}

void postOrder(struct node *node)
{
	if(node != NULL)
	{
		postOrder(node->left);
		postOrder(node->right);
		printf("%d ",node->data);
	}
}

void inOrder(struct node *node)
{
	if(node != NULL)
	{
		inOrder(node->left);
		printf("%d ",node->data);
		inOrder(node->right);
	}
}

int main()
{
	struct node *root = newnode(1);
	root->left = newnode(2);
	root->right = newnode(3);
	root->left->left = newnode(4);
 	root->left->right = newnode(5); 

	printf("\n Preorder traversal of binary tree is \n");
        preOrder(root);
 
        printf("\n Inorder traversal of binary tree is \n");
        inOrder(root);  
 
        printf("\n Postorder traversal of binary tree is \n");
        postOrder(root);
 
	return 0;
}
