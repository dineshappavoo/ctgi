	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp2:
	.cfi_def_cfa_offset 16
Ltmp3:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp4:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	$0, -4(%rbp)
	callq	_showMacrosWithoutDefinition
	callq	_showMacrosWithValues
	callq	_showMacrosFromCommandLine
	callq	_showMacroWithCode
	movl	$0, %eax
	addq	$16, %rsp
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_showMacrosWithoutDefinition
	.align	4, 0x90
_showMacrosWithoutDefinition:           ## @showMacrosWithoutDefinition
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp7:
	.cfi_def_cfa_offset 16
Ltmp8:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp9:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	leaq	L_.str(%rip), %rdi
	movb	$0, %al
	callq	_printf
	leaq	L_.str1(%rip), %rdi
	movl	%eax, -4(%rbp)          ## 4-byte Spill
	movb	$0, %al
	callq	_printf
	movl	%eax, -8(%rbp)          ## 4-byte Spill
	addq	$16, %rsp
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_showMacrosWithValues
	.align	4, 0x90
_showMacrosWithValues:                  ## @showMacrosWithValues
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp12:
	.cfi_def_cfa_offset 16
Ltmp13:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp14:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	leaq	L_.str2(%rip), %rdi
	movl	$1024, %esi             ## imm = 0x400
	movb	$0, %al
	callq	_printf
	movl	%eax, -4(%rbp)          ## 4-byte Spill
	addq	$16, %rsp
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_showMacrosFromCommandLine
	.align	4, 0x90
_showMacrosFromCommandLine:             ## @showMacrosFromCommandLine
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp17:
	.cfi_def_cfa_offset 16
Ltmp18:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp19:
	.cfi_def_cfa_register %rbp
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_showMacroWithCode
	.align	4, 0x90
_showMacroWithCode:                     ## @showMacroWithCode
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp22:
	.cfi_def_cfa_offset 16
Ltmp23:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp24:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	leaq	L_.str3(%rip), %rdi
	movb	$0, %al
	callq	_printf
	leaq	L_.str4(%rip), %rdi
	movl	$5, -4(%rbp)
	movl	-4(%rbp), %ecx
	imull	-4(%rbp), %ecx
	movl	%ecx, %esi
	movl	%eax, -8(%rbp)          ## 4-byte Spill
	movb	$0, %al
	callq	_printf
	movl	%eax, -12(%rbp)         ## 4-byte Spill
	addq	$16, %rsp
	popq	%rbp
	retq
	.cfi_endproc

	.section	__TEXT,__const
	.globl	_MAX                    ## @MAX
	.align	2
_MAX:
	.long	3                       ## 0x3

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"Macro1 is defined\n"

L_.str1:                                ## @.str1
	.asciz	"Macro2 is defined\n"

L_.str2:                                ## @.str2
	.asciz	"BUFFER_SIZE defined with value [%d]\n"

L_.str3:                                ## @.str3
	.asciz	"SQUARE is defined\n"

L_.str4:                                ## @.str4
	.asciz	"Macro function result %d\n"


.subsections_via_symbols
