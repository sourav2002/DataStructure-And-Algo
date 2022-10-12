#include<iostream>
using namespace std;


int main()
{
	int size,pos;
	cout<<"How many elements you want to enter : ";
	cin>>size;
	int a[size];
	for(int i=0;i<size;i++)
	{
		cout<<"Enter data : ";
		cin>>a[i];
	}
	
	cout<<"\n";
	for(int i=0;i<size;i++)
	{
		cout<<a[i]<<"\t";
	}
	
	cout<<"\nenter position to delete that data : ";
	cin>>pos;
	for(int i=pos-1;i<size;i++)
	{
		a[i] = a[i+1];
	}
	
	cout<<"\n";
	cout<<"After deletion : \n";
	for(int i=0;i<size-1;i++)
	{
		cout<<a[i]<<"\t";
	}
	
	
	return 0;
}
