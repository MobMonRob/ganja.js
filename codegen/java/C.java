// 3D Projective Geometric Algebra
// Written by a generator written by enki.
package de.dhbw.rahmlab.ganjatest.impl;

import java.util.Arrays;

public class C {
	// just for debug and print output, the basis names
	public static final String[] _basis = new String[] { "1","e1" };
	public static final int _basisLength = 2;

	private double[] _mVec = new double[C._basisLength];

	public static final C Empty = new C();

	/// <summary>
	/// Ctor
	/// </summary>
	/// <param name="f"></param>
	/// <param name="idx"></param>
	public C(int idx, double value) {
		Arrays.fill(this._mVec, 0d);
		this._mVec[idx] = value;
	}

	/// <summary>
	/// Ctor
	/// </summary>
	public C() {
		Arrays.fill(this._mVec, 0d);
	}

	/// <summary>
	/// Ctor
	/// </summary>
	public C(final C other) {
		this._mVec = other._mVec;
	}

	public double get(int idx) {
		return this._mVec[idx];
	}

	public void set(int idx, double value) {
		this._mVec[idx] = value;
	}



	/// <summary>
	/// unary operator
	/// C.Reverse : res = ~a
	/// Reverse the order of the basis blades.
	/// </summary>
	public static C unop_Reverse (C a_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;

		res[0]=a[0];
		res[1]=a[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// unary operator
	/// C.Dual : res = !a
	/// Poincare duality operator.
	/// </summary>
	public static C unop_Dual (C a_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;

		res[0]=-a[1];
		res[1]=a[0];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// unary operator
	/// C.Conjugate : res = a.Conjugate()
	/// Clifford Conjugation
	/// </summary>
	public  C Conjugate ()
	{
		double[] res = new double[C._basisLength];
		

		res[0]=this._mVec[0];
		res[1]=-this._mVec[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// unary operator
	/// C.Involute : res = a.Involute()
	/// Main involution
	/// </summary>
	public  C Involute ()
	{
		double[] res = new double[C._basisLength];
		

		res[0]=this._mVec[0];
		res[1]=-this._mVec[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.Mul : res = a * b
	/// The geometric product.
	/// </summary>
	public static C binop_Mul (C a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0]=b[0]*a[0]-b[1]*a[1];
		res[1]=b[1]*a[0]+b[0]*a[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.Wedge : res = a ^ b
	/// The outer product. (MEET)
	/// </summary>
	public static C binop_Wedge (C a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0]=b[0]*a[0];
		res[1]=b[1]*a[0]+b[0]*a[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.Vee : res = a & b
	/// The regressive product. (JOIN)
	/// </summary>
	public static C binop_Vee (C a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[1]=1*(a[1]*b[1]);
		res[0]=1*(a[0]*b[1]+a[1]*b[0]);

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.Dot : res = a | b
	/// The inner product.
	/// </summary>
	public static C binop_Dot (C a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0]=b[0]*a[0]-b[1]*a[1];
		res[1]=b[1]*a[0]+b[0]*a[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.Add : res = a + b
	/// Multivector addition
	/// </summary>
	public static C binop_Add (C a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0] = a[0]+b[0];
		res[1] = a[1]+b[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.Sub : res = a - b
	/// Multivector subtraction
	/// </summary>
	public static C binop_Sub (C a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0] = a[0]-b[0];
		res[1] = a[1]-b[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.smul : res = a * b
	/// scalar/multivector multiplication
	/// </summary>
	public static C binop_smul (double a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double a = a_param;
		double[] b = b_param._mVec;

		res[0] = a*b[0];
		res[1] = a*b[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.muls : res = a * b
	/// multivector/scalar multiplication
	/// </summary>
	public static C binop_muls (C a_param, double b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double b = b_param;

		res[0] = a[0]*b;
		res[1] = a[1]*b;

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.sadd : res = a + b
	/// scalar/multivector addition
	/// </summary>
	public static C binop_sadd (double a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double a = a_param;
		double[] b = b_param._mVec;

		res[0] = a+b[0];
		res[1] = b[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.adds : res = a + b
	/// multivector/scalar addition
	/// </summary>
	public static C binop_adds (C a_param, double b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double b = b_param;

		res[0] = a[0]+b;
		res[1] = a[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.ssub : res = a - b
	/// scalar/multivector subtraction
	/// </summary>
	public static C binop_ssub (double a_param, C b_param)
	{
		double[] res = new double[C._basisLength];
		double a = a_param;
		double[] b = b_param._mVec;

		res[0] = a-b[0];
		res[1] = -b[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// C.subs : res = a - b
	/// multivector/scalar subtraction
	/// </summary>
	public static C binop_subs (C a_param, double b_param)
	{
		double[] res = new double[C._basisLength];
		double[] a = a_param._mVec;
		double b = b_param;

		res[0] = a[0]-b;
		res[1] = a[1];

		C res_ret = new C(C.Empty);
		res_ret._mVec = res;
		return res_ret;
	}


/// <summary>
	/// C.norm()
	/// Calculate the Euclidean norm. (strict positive).
	/// </summary>
	public double norm() {
		return Math.sqrt(Math.abs(binop_Mul(this, this.Conjugate())._mVec[0]));
	}

	/// <summary>
	/// C.inorm()
	/// Calculate the Ideal norm. (signed)
	/// </summary>
	public double inorm() {
		return unop_Dual(this).norm();
	}

	/// <summary>
	/// C.normalized()
	/// Returns a normalized (Euclidean) element.
	/// </summary>
	public C normalized() {
		return binop_muls(this, 1d / norm());
	}

	
	// The basis blades
	public static final C e1 = new C(1, 1d);

}

