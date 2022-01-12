// 3D Projective Geometric Algebra
// Written by a generator written by enki.
package de.dhbw.rahmlab.ganjatest.impl;

import java.util.Arrays;

public class R111 	{
	// just for debug and print output, the basis names
	public static final String[] _basis = new String[] { "1","e0","e1","e2","e01","e02","e12","e012" };
	private static final int _basisLength = 8;

	private double[] _mVec = new double[R111._basisLength];

	/// <summary>
	/// Ctor
	/// </summary>
	/// <param name="f"></param>
	/// <param name="idx"></param>
	public R111(int idx, double value) {
		Arrays.fill(this._mVec, 0d);
		this._mVec[idx] = value;
	}

	/// <summary>
	/// Ctor
	/// </summary>
	/// <param name="f"></param>
	/// <param name="idx"></param>
	public R111() {
		Arrays.fill(this._mVec, 0d);
	}

	public double get(int idx) {
		return this._mVec[idx];
	}

	public void set(int idx, double value) {
		this._mVec[idx] = value;
	}



	/// <summary>
	/// unary operator
	/// R111.Reverse : res = ~a
	/// Reverse the order of the basis blades.
	/// </summary>
	public static R111 unop_Reverse (R111 a_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;

		res[0]=a[0];
		res[1]=a[1];
		res[2]=a[2];
		res[3]=a[3];
		res[4]=-a[4];
		res[5]=-a[5];
		res[6]=-a[6];
		res[7]=-a[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// unary operator
	/// R111.Dual : res = !a
	/// Poincare duality operator.
	/// </summary>
	public static R111 unop_Dual (R111 a_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;

		res[0]=a[7];
		res[1]=a[6];
		res[2]=a[5];
		res[3]=a[4];
		res[4]=a[3];
		res[5]=a[2];
		res[6]=a[1];
		res[7]=a[0];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// unary operator
	/// R111.Conjugate : res = a.Conjugate()
	/// Clifford Conjugation
	/// </summary>
	public  R111 Conjugate ()
	{
		double[] res = new double[R111._basisLength];
		

		res[0]=res[0];
		res[1]=-res[1];
		res[2]=-res[2];
		res[3]=-res[3];
		res[4]=-res[4];
		res[5]=-res[5];
		res[6]=-res[6];
		res[7]=res[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// unary operator
	/// R111.Involute : res = a.Involute()
	/// Main involution
	/// </summary>
	public  R111 Involute ()
	{
		double[] res = new double[R111._basisLength];
		

		res[0]=res[0];
		res[1]=-res[1];
		res[2]=-res[2];
		res[3]=-res[3];
		res[4]=res[4];
		res[5]=res[5];
		res[6]=res[6];
		res[7]=-res[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.Mul : res = a * b
	/// The geometric product.
	/// </summary>
	public static R111 binop_Mul (R111 a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0]=b[0]*a[0]+b[2]*a[2]-b[3]*a[3]+b[6]*a[6];
		res[1]=b[1]*a[0]+b[0]*a[1]-b[4]*a[2]+b[5]*a[3]+b[2]*a[4]-b[3]*a[5]+b[7]*a[6]+b[6]*a[7];
		res[2]=b[2]*a[0]+b[0]*a[2]+b[6]*a[3]-b[3]*a[6];
		res[3]=b[3]*a[0]+b[6]*a[2]+b[0]*a[3]-b[2]*a[6];
		res[4]=b[4]*a[0]+b[2]*a[1]-b[1]*a[2]-b[7]*a[3]+b[0]*a[4]+b[6]*a[5]-b[5]*a[6]-b[3]*a[7];
		res[5]=b[5]*a[0]+b[3]*a[1]-b[7]*a[2]-b[1]*a[3]+b[6]*a[4]+b[0]*a[5]-b[4]*a[6]-b[2]*a[7];
		res[6]=b[6]*a[0]+b[3]*a[2]-b[2]*a[3]+b[0]*a[6];
		res[7]=b[7]*a[0]+b[6]*a[1]-b[5]*a[2]+b[4]*a[3]+b[3]*a[4]-b[2]*a[5]+b[1]*a[6]+b[0]*a[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.Wedge : res = a ^ b
	/// The outer product. (MEET)
	/// </summary>
	public static R111 binop_Wedge (R111 a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0]=b[0]*a[0];
		res[1]=b[1]*a[0]+b[0]*a[1];
		res[2]=b[2]*a[0]+b[0]*a[2];
		res[3]=b[3]*a[0]+b[0]*a[3];
		res[4]=b[4]*a[0]+b[2]*a[1]-b[1]*a[2]+b[0]*a[4];
		res[5]=b[5]*a[0]+b[3]*a[1]-b[1]*a[3]+b[0]*a[5];
		res[6]=b[6]*a[0]+b[3]*a[2]-b[2]*a[3]+b[0]*a[6];
		res[7]=b[7]*a[0]+b[6]*a[1]-b[5]*a[2]+b[4]*a[3]+b[3]*a[4]-b[2]*a[5]+b[1]*a[6]+b[0]*a[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.Vee : res = a & b
	/// The regressive product. (JOIN)
	/// </summary>
	public static R111 binop_Vee (R111 a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[7]=1*(a[7]*b[7]);
		res[6]=1*(a[6]*b[7]+a[7]*b[6]);
		res[5]=-1*(a[5]*-1*b[7]+a[7]*b[5]*-1);
		res[4]=1*(a[4]*b[7]+a[7]*b[4]);
		res[3]=1*(a[3]*b[7]+a[5]*-1*b[6]-a[6]*b[5]*-1+a[7]*b[3]);
		res[2]=-1*(a[2]*-1*b[7]+a[4]*b[6]-a[6]*b[4]+a[7]*b[2]*-1);
		res[1]=1*(a[1]*b[7]+a[4]*b[5]*-1-a[5]*-1*b[4]+a[7]*b[1]);
		res[0]=1*(a[0]*b[7]+a[1]*b[6]-a[2]*-1*b[5]*-1+a[3]*b[4]+a[4]*b[3]-a[5]*-1*b[2]*-1+a[6]*b[1]+a[7]*b[0]);

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.Dot : res = a | b
	/// The inner product.
	/// </summary>
	public static R111 binop_Dot (R111 a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0]=b[0]*a[0]+b[2]*a[2]-b[3]*a[3]+b[6]*a[6];
		res[1]=b[1]*a[0]+b[0]*a[1]-b[4]*a[2]+b[5]*a[3]+b[2]*a[4]-b[3]*a[5]+b[7]*a[6]+b[6]*a[7];
		res[2]=b[2]*a[0]+b[0]*a[2]+b[6]*a[3]-b[3]*a[6];
		res[3]=b[3]*a[0]+b[6]*a[2]+b[0]*a[3]-b[2]*a[6];
		res[4]=b[4]*a[0]-b[7]*a[3]+b[0]*a[4]-b[3]*a[7];
		res[5]=b[5]*a[0]-b[7]*a[2]+b[0]*a[5]-b[2]*a[7];
		res[6]=b[6]*a[0]+b[0]*a[6];
		res[7]=b[7]*a[0]+b[0]*a[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.Add : res = a + b
	/// Multivector addition
	/// </summary>
	public static R111 binop_Add (R111 a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0] = a[0]+b[0];
		res[1] = a[1]+b[1];
		res[2] = a[2]+b[2];
		res[3] = a[3]+b[3];
		res[4] = a[4]+b[4];
		res[5] = a[5]+b[5];
		res[6] = a[6]+b[6];
		res[7] = a[7]+b[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.Sub : res = a - b
	/// Multivector subtraction
	/// </summary>
	public static R111 binop_Sub (R111 a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double[] b = b_param._mVec;

		res[0] = a[0]-b[0];
		res[1] = a[1]-b[1];
		res[2] = a[2]-b[2];
		res[3] = a[3]-b[3];
		res[4] = a[4]-b[4];
		res[5] = a[5]-b[5];
		res[6] = a[6]-b[6];
		res[7] = a[7]-b[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.smul : res = a * b
	/// scalar/multivector multiplication
	/// </summary>
	public static R111 binop_smul (double a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double a = a_param;
		double[] b = b_param._mVec;

		res[0] = a*b[0];
		res[1] = a*b[1];
		res[2] = a*b[2];
		res[3] = a*b[3];
		res[4] = a*b[4];
		res[5] = a*b[5];
		res[6] = a*b[6];
		res[7] = a*b[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.muls : res = a * b
	/// multivector/scalar multiplication
	/// </summary>
	public static R111 binop_muls (R111 a_param, double b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double b = b_param;

		res[0] = a[0]*b;
		res[1] = a[1]*b;
		res[2] = a[2]*b;
		res[3] = a[3]*b;
		res[4] = a[4]*b;
		res[5] = a[5]*b;
		res[6] = a[6]*b;
		res[7] = a[7]*b;

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.sadd : res = a + b
	/// scalar/multivector addition
	/// </summary>
	public static R111 binop_sadd (double a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double a = a_param;
		double[] b = b_param._mVec;

		res[0] = a+b[0];
		res[1] = b[1];
		res[2] = b[2];
		res[3] = b[3];
		res[4] = b[4];
		res[5] = b[5];
		res[6] = b[6];
		res[7] = b[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.adds : res = a + b
	/// multivector/scalar addition
	/// </summary>
	public static R111 binop_adds (R111 a_param, double b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double b = b_param;

		res[0] = a[0]+b;
		res[1] = a[1];
		res[2] = a[2];
		res[3] = a[3];
		res[4] = a[4];
		res[5] = a[5];
		res[6] = a[6];
		res[7] = a[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.ssub : res = a - b
	/// scalar/multivector subtraction
	/// </summary>
	public static R111 binop_ssub (double a_param, R111 b_param)
	{
		double[] res = new double[R111._basisLength];
		double a = a_param;
		double[] b = b_param._mVec;

		res[0] = a-b[0];
		res[1] = -b[1];
		res[2] = -b[2];
		res[3] = -b[3];
		res[4] = -b[4];
		res[5] = -b[5];
		res[6] = -b[6];
		res[7] = -b[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


	/// <summary>
	/// binary operator
	/// R111.subs : res = a - b
	/// multivector/scalar subtraction
	/// </summary>
	public static R111 binop_subs (R111 a_param, double b_param)
	{
		double[] res = new double[R111._basisLength];
		double[] a = a_param._mVec;
		double b = b_param;

		res[0] = a[0]-b;
		res[1] = a[1];
		res[2] = a[2];
		res[3] = a[3];
		res[4] = a[4];
		res[5] = a[5];
		res[6] = a[6];
		res[7] = a[7];

		R111 res_ret = new R111();
		res_ret._mVec = res;
		return res_ret;
	}


/// <summary>
	/// R111.norm()
	/// Calculate the Euclidean norm. (strict positive).
	/// </summary>
	public double norm() {
		return Math.sqrt(Math.abs(binop_Mul(this, this.Conjugate())._mVec[0]));
	}

	/// <summary>
	/// R111.inorm()
	/// Calculate the Ideal norm. (signed)
	/// </summary>
	public double inorm() {
		return unop_Dual(this).norm();
	}

	/// <summary>
	/// R111.normalized()
	/// Returns a normalized (Euclidean) element.
	/// </summary>
	public R111 normalized() {
		return binop_muls(this, 1d / norm());
	}

	
	// The basis blades
	public static final R111 e0 = new R111(1, 1d);
	public static final R111 e1 = new R111(2, 1d);
	public static final R111 e2 = new R111(3, 1d);
	public static final R111 e01 = new R111(4, 1d);
	public static final R111 e02 = new R111(5, 1d);
	public static final R111 e12 = new R111(6, 1d);
	public static final R111 e012 = new R111(7, 1d);

}

