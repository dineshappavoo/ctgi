; File: arrayinc.asm
;
; A subroutine to be called from C programs.
; Parameters: int A[], int n
; Result: A[0], ... A[n-1] are each incremented by 1


SECTION .text
global arrayinc

arrayinc:
push    ebp                     ; set up stack frame
mov     ebp, esp

; registers ebx, esi and edi must be saved, if used
push    ebx
push    edi

mov     edi, [ebp+8]            ; get address of A
mov     ecx, [ebp+12]           ; get num of elts
mov     ebx, 0                  ; initialize count

for_loop:
mov     eax, [edi+4*ebx]        ; get array element
inc     eax                     ; add 1
mov     [edi+4*ebx], eax        ; put it back
inc     ebx                     ; update counter
loop    for_loop

pop     edi                     ; restore registers
pop     ebx

mov     esp, ebp                ; take down stack frame
pop     ebp

ret