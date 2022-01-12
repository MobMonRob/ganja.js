// cs Template for the preamble
var preamble = (basis,classname)=>
`// 3D Projective Geometric Algebra
// Written by a generator written by enki.
package de.dhbw.rahmlab.ganjatest.impl;

import java.util.Arrays;

public class ${classname} {
	// just for debug and print output, the basis names
	public static final String[] _basis = new String[] { ${basis.map(x=>'"'+x+'"').join(',')} };
	public static final int _basisLength = ${basis.length};

	private double[] _mVec = new double[${classname}._basisLength];

	public static final ${classname} Empty = new ${classname}();

	/// <summary>
	/// Ctor
	/// </summary>
	/// <param name="f"></param>
	/// <param name="idx"></param>
	public ${classname}(int idx, double value) {
		Arrays.fill(this._mVec, 0d);
		this._mVec[idx] = value;
	}

	/// <summary>
	/// Ctor
	/// </summary>
	public ${classname}() {
		Arrays.fill(this._mVec, 0d);
	}

	/// <summary>
	/// Ctor
	/// </summary>
	public ${classname}(final ${classname} other) {
		this._mVec = other._mVec;
	}

	public double get(int idx) {
		return this._mVec[idx];
	}

	public void set(int idx, double value) {
		this._mVec[idx] = value;
	}
`;

// cs Template for our binary operators

var binary = (classname, symbol, name, name_a, name_b, name_ret, code, classname_a=classname, classname_b=classname,desc='')=> {
	let body = ``;
	let aDefiniton = ``;
	let bDefiniton = ``;

	if (classname == classname_a) {
		aDefiniton = `double[] ${name_a} = ${name_a+"_param"}._mVec;`;
	} else {
		aDefiniton = `${classname_a} ${name_a} = ${name_a+"_param"};`;
	}

	if (classname == classname_b) {
		bDefiniton = `double[] ${name_b} = ${name_b+"_param"}._mVec;`;
	} else {
		bDefiniton = `${classname_b} ${name_b} = ${name_b+"_param"};`;
	}

body = `
	/// <summary>
	/// binary operator
	/// ${classname}.${name} : ${name_ret} = ${symbol?name_a+" "+symbol+" "+name_b:name_a+"."+name+"("+name_b+")"}
	/// ${desc}
	/// </summary>
	public static ${classname} ${name?"binop_"+name:name} (${classname_a} ${name_a+"_param"}, ${classname_b} ${name_b+"_param"})
	{
		double[] ${name_ret} = new double[${classname}._basisLength];
		${aDefiniton}
		${bDefiniton}

${code.replace(/^\s*/gm,'		')}

		${classname} ${name_ret}_ret = new ${classname}(${classname}.Empty);
		${name_ret}_ret._mVec = ${name_ret};
		return ${name_ret}_ret;
	}`

	return body;
}

// cs Template for our unary operators

var unary = (classname, symbol, name, name_a, name_ret, code, classname_a=classname,desc='')=> {
	let body = ``;
	let aDefiniton = ``;

	if (symbol != null) {
		aDefiniton = `double[] ${name_a} = ${name_a+"_param"}._mVec;`;
	} else {
		aDefiniton = ``;
	}

body=`
	/// <summary>
	/// unary operator
	/// ${classname}.${name} : ${name_ret} = ${symbol?symbol+name_a:name_a+"."+name+"()"}
	/// ${desc}
	/// </summary>
	public ${symbol?"static":""} ${classname} ${symbol?"unop_"+name:name} (${symbol?`${classname_a} ${name_a+"_param"}`:``})
	{
		double[] ${name_ret} = new double[${classname}._basisLength];
		${aDefiniton}

${(symbol?code:code.replace(/a\[/g,"this._mVec[")).replace(/^\s*/gm,'		')}

		${classname} ${name_ret}_ret = new ${classname}(${classname}.Empty);
		${name_ret}_ret._mVec = ${name_ret};
		return ${name_ret}_ret;
	}`

	return body;
}

// cs template for algebras where I don't have specific examples yet ..
var GENERIC = (basis, classname)=>({
preamble:`
	// The basis blades
${basis.slice(1).map((x,i)=>`	public static final ${classname} ${x} = new ${classname}(${i+1}, 1d);`).join('\n')}
`
})


// cs Template for the postamble
var postamble = (basis, classname, example)=>
`
/// <summary>
	/// ${classname}.norm()
	/// Calculate the Euclidean norm. (strict positive).
	/// </summary>
	public double norm() {
		return Math.sqrt(Math.abs(binop_Mul(this, this.Conjugate())._mVec[0]));
	}

	/// <summary>
	/// ${classname}.inorm()
	/// Calculate the Ideal norm. (signed)
	/// </summary>
	public double inorm() {
		return unop_Dual(this).norm();
	}

	/// <summary>
	/// ${classname}.normalized()
	/// Returns a normalized (Euclidean) element.
	/// </summary>
	public ${classname} normalized() {
		return binop_muls(this, 1d / norm());
	}

	${example.preamble}
}

`;


Object.assign(exports,{preamble,postamble,unary,binary,desc:"java",GENERIC});

