//
//  bitmanipulation.c
//  bitmanipulation
//
//  Created by Dinesh Appavoo on 1/31/15.
//  Copyright (c) 2015 Dinesh Appavoo. All rights reserved.
//
//QUESTION:Write and aligned malloc() that gets memory size needed and an alignment mask as its arguements.Write a free() function to go with the aligned malloc that takes only the pointer to the allocated chunk of memory

#include <stdlib.h>
#include <stdio.h>


void* aligned_malloc(size_t required_bytes, size_t alignment)
{
    void* p1; // original block
    void** p2; // aligned block
    int offset = alignment - 1 + sizeof(void*);
    if ((p1 = (void*)malloc(required_bytes + offset)) == NULL)
    {
        return NULL;
    }
    p2 = (void**)(((size_t)(p1) + offset) & ~(alignment - 1));
    
    p2[-1] = p1;
    return p2;
}


void aligned_free(void *p)
{
    free(((void**)p)[-1]);
}

int main (int argc, char *argv[])
{
    char **endptr;
    int *p = aligned_malloc (10, 4);
    
    printf ("%s: %p\n", argv[1], p);
    aligned_free (p);
    return 0;
}