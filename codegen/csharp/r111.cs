// 3D Projective Geometric Algebra
// Written by a generator written by enki.
using System;
using System.Text;
using static R11.R111; // static variable acces

namespace R11
{
	public class R111
	{
		// just for debug and print output, the basis names
		public static string[] _basis = new[] { "1","e0","e1","e2","e01","e02","e12","e012" };

		private float[] _mVec = new float[8];

		/// <summary>
		/// Ctor
		/// </summary>
		/// <param name="f"></param>
		/// <param name="idx"></param>
		public R111(float f = 0f, int idx = 0)
		{
			_mVec[idx] = f;
		}

		#region Array Access
		public float this[int idx]
		{
			get { return _mVec[idx]; }
			set { _mVec[idx] = value; }
		}
		#endregion

		#region Overloaded Operators

		/// <summary>
		/// R111.Reverse : res = ~a
		/// Reverse the order of the basis blades.
		/// </summary>
		public static R111 operator ~ (R111 a)
		{
			R111 res = new R111();
			res[0]=a[0];
			res[1]=a[1];
			res[2]=a[2];
			res[3]=a[3];
			res[4]=-a[4];
			res[5]=-a[5];
			res[6]=-a[6];
			res[7]=-a[7];
			return res;
		}

		/// <summary>
		/// R111.Dual : res = !a
		/// Poincare duality operator.
		/// </summary>
		public static R111 operator ! (R111 a)
		{
			R111 res = new R111();
			res[0]=a[7];
			res[1]=a[6];
			res[2]=a[5];
			res[3]=a[4];
			res[4]=a[3];
			res[5]=a[2];
			res[6]=a[1];
			res[7]=a[0];
			return res;
		}

		/// <summary>
		/// R111.Conjugate : res = a.Conjugate()
		/// Clifford Conjugation
		/// </summary>
		public  R111 Conjugate ()
		{
			R111 res = new R111();
			res[0]=this[0];
			res[1]=-this[1];
			res[2]=-this[2];
			res[3]=-this[3];
			res[4]=-this[4];
			res[5]=-this[5];
			res[6]=-this[6];
			res[7]=this[7];
			return res;
		}

		/// <summary>
		/// R111.Involute : res = a.Involute()
		/// Main involution
		/// </summary>
		public  R111 Involute ()
		{
			R111 res = new R111();
			res[0]=this[0];
			res[1]=-this[1];
			res[2]=-this[2];
			res[3]=-this[3];
			res[4]=this[4];
			res[5]=this[5];
			res[6]=this[6];
			res[7]=-this[7];
			return res;
		}

		/// <summary>
		/// R111.Mul : res = a * b
		/// The geometric product.
		/// </summary>
		public static R111 operator * (R111 a, R111 b)
		{
			R111 res = new R111();
			res[0]=b[0]*a[0]+b[2]*a[2]-b[3]*a[3]+b[6]*a[6];
			res[1]=b[1]*a[0]+b[0]*a[1]-b[4]*a[2]+b[5]*a[3]+b[2]*a[4]-b[3]*a[5]+b[7]*a[6]+b[6]*a[7];
			res[2]=b[2]*a[0]+b[0]*a[2]+b[6]*a[3]-b[3]*a[6];
			res[3]=b[3]*a[0]+b[6]*a[2]+b[0]*a[3]-b[2]*a[6];
			res[4]=b[4]*a[0]+b[2]*a[1]-b[1]*a[2]-b[7]*a[3]+b[0]*a[4]+b[6]*a[5]-b[5]*a[6]-b[3]*a[7];
			res[5]=b[5]*a[0]+b[3]*a[1]-b[7]*a[2]-b[1]*a[3]+b[6]*a[4]+b[0]*a[5]-b[4]*a[6]-b[2]*a[7];
			res[6]=b[6]*a[0]+b[3]*a[2]-b[2]*a[3]+b[0]*a[6];
			res[7]=b[7]*a[0]+b[6]*a[1]-b[5]*a[2]+b[4]*a[3]+b[3]*a[4]-b[2]*a[5]+b[1]*a[6]+b[0]*a[7];
			return res;
		}

		/// <summary>
		/// R111.Wedge : res = a ^ b
		/// The outer product. (MEET)
		/// </summary>
		public static R111 operator ^ (R111 a, R111 b)
		{
			R111 res = new R111();
			res[0]=b[0]*a[0];
			res[1]=b[1]*a[0]+b[0]*a[1];
			res[2]=b[2]*a[0]+b[0]*a[2];
			res[3]=b[3]*a[0]+b[0]*a[3];
			res[4]=b[4]*a[0]+b[2]*a[1]-b[1]*a[2]+b[0]*a[4];
			res[5]=b[5]*a[0]+b[3]*a[1]-b[1]*a[3]+b[0]*a[5];
			res[6]=b[6]*a[0]+b[3]*a[2]-b[2]*a[3]+b[0]*a[6];
			res[7]=b[7]*a[0]+b[6]*a[1]-b[5]*a[2]+b[4]*a[3]+b[3]*a[4]-b[2]*a[5]+b[1]*a[6]+b[0]*a[7];
			return res;
		}

		/// <summary>
		/// R111.Vee : res = a & b
		/// The regressive product. (JOIN)
		/// </summary>
		public static R111 operator & (R111 a, R111 b)
		{
			R111 res = new R111();
			res[7]=1*(a[7]*b[7]);
			res[6]=1*(a[6]*b[7]+a[7]*b[6]);
			res[5]=-1*(a[5]*-1*b[7]+a[7]*b[5]*-1);
			res[4]=1*(a[4]*b[7]+a[7]*b[4]);
			res[3]=1*(a[3]*b[7]+a[5]*-1*b[6]-a[6]*b[5]*-1+a[7]*b[3]);
			res[2]=-1*(a[2]*-1*b[7]+a[4]*b[6]-a[6]*b[4]+a[7]*b[2]*-1);
			res[1]=1*(a[1]*b[7]+a[4]*b[5]*-1-a[5]*-1*b[4]+a[7]*b[1]);
			res[0]=1*(a[0]*b[7]+a[1]*b[6]-a[2]*-1*b[5]*-1+a[3]*b[4]+a[4]*b[3]-a[5]*-1*b[2]*-1+a[6]*b[1]+a[7]*b[0]);
			return res;
		}

		/// <summary>
		/// R111.Dot : res = a | b
		/// The inner product.
		/// </summary>
		public static R111 operator | (R111 a, R111 b)
		{
			R111 res = new R111();
			res[0]=b[0]*a[0]+b[2]*a[2]-b[3]*a[3]+b[6]*a[6];
			res[1]=b[1]*a[0]+b[0]*a[1]-b[4]*a[2]+b[5]*a[3]+b[2]*a[4]-b[3]*a[5]+b[7]*a[6]+b[6]*a[7];
			res[2]=b[2]*a[0]+b[0]*a[2]+b[6]*a[3]-b[3]*a[6];
			res[3]=b[3]*a[0]+b[6]*a[2]+b[0]*a[3]-b[2]*a[6];
			res[4]=b[4]*a[0]-b[7]*a[3]+b[0]*a[4]-b[3]*a[7];
			res[5]=b[5]*a[0]-b[7]*a[2]+b[0]*a[5]-b[2]*a[7];
			res[6]=b[6]*a[0]+b[0]*a[6];
			res[7]=b[7]*a[0]+b[0]*a[7];
			return res;
		}

		/// <summary>
		/// R111.Add : res = a + b
		/// Multivector addition
		/// </summary>
		public static R111 operator + (R111 a, R111 b)
		{
			R111 res = new R111();
			res[0] = a[0]+b[0];
			res[1] = a[1]+b[1];
			res[2] = a[2]+b[2];
			res[3] = a[3]+b[3];
			res[4] = a[4]+b[4];
			res[5] = a[5]+b[5];
			res[6] = a[6]+b[6];
			res[7] = a[7]+b[7];
			return res;
		}

		/// <summary>
		/// R111.Sub : res = a - b
		/// Multivector subtraction
		/// </summary>
		public static R111 operator - (R111 a, R111 b)
		{
			R111 res = new R111();
			res[0] = a[0]-b[0];
			res[1] = a[1]-b[1];
			res[2] = a[2]-b[2];
			res[3] = a[3]-b[3];
			res[4] = a[4]-b[4];
			res[5] = a[5]-b[5];
			res[6] = a[6]-b[6];
			res[7] = a[7]-b[7];
			return res;
		}

		/// <summary>
		/// R111.smul : res = a * b
		/// scalar/multivector multiplication
		/// </summary>
		public static R111 operator * (float a, R111 b)
		{
			R111 res = new R111();
			res[0] = a*b[0];
			res[1] = a*b[1];
			res[2] = a*b[2];
			res[3] = a*b[3];
			res[4] = a*b[4];
			res[5] = a*b[5];
			res[6] = a*b[6];
			res[7] = a*b[7];
			return res;
		}

		/// <summary>
		/// R111.muls : res = a * b
		/// multivector/scalar multiplication
		/// </summary>
		public static R111 operator * (R111 a, float b)
		{
			R111 res = new R111();
			res[0] = a[0]*b;
			res[1] = a[1]*b;
			res[2] = a[2]*b;
			res[3] = a[3]*b;
			res[4] = a[4]*b;
			res[5] = a[5]*b;
			res[6] = a[6]*b;
			res[7] = a[7]*b;
			return res;
		}

		/// <summary>
		/// R111.sadd : res = a + b
		/// scalar/multivector addition
		/// </summary>
		public static R111 operator + (float a, R111 b)
		{
			R111 res = new R111();
			res[0] = a+b[0];
			res[1] = b[1];
			res[2] = b[2];
			res[3] = b[3];
			res[4] = b[4];
			res[5] = b[5];
			res[6] = b[6];
			res[7] = b[7];
			return res;
		}

		/// <summary>
		/// R111.adds : res = a + b
		/// multivector/scalar addition
		/// </summary>
		public static R111 operator + (R111 a, float b)
		{
			R111 res = new R111();
			res[0] = a[0]+b;
			res[1] = a[1];
			res[2] = a[2];
			res[3] = a[3];
			res[4] = a[4];
			res[5] = a[5];
			res[6] = a[6];
			res[7] = a[7];
			return res;
		}

		/// <summary>
		/// R111.ssub : res = a - b
		/// scalar/multivector subtraction
		/// </summary>
		public static R111 operator - (float a, R111 b)
		{
			R111 res = new R111();
			res[0] = a-b[0];
			res[1] = -b[1];
			res[2] = -b[2];
			res[3] = -b[3];
			res[4] = -b[4];
			res[5] = -b[5];
			res[6] = -b[6];
			res[7] = -b[7];
			return res;
		}

		/// <summary>
		/// R111.subs : res = a - b
		/// multivector/scalar subtraction
		/// </summary>
		public static R111 operator - (R111 a, float b)
		{
			R111 res = new R111();
			res[0] = a[0]-b;
			res[1] = a[1];
			res[2] = a[2];
			res[3] = a[3];
			res[4] = a[4];
			res[5] = a[5];
			res[6] = a[6];
			res[7] = a[7];
			return res;
		}

		#endregion

                /// <summary>
                /// R111.norm()
                /// Calculate the Euclidean norm. (strict positive).
                /// </summary>
		public float norm() { return (float) Math.Sqrt(Math.Abs((this*this.Conjugate())[0]));}
		
		/// <summary>
		/// R111.inorm()
		/// Calculate the Ideal norm. (signed)
		/// </summary>
		public float inorm() { return this[1]!=0.0f?this[1]:this[15]!=0.0f?this[15]:(!this).norm();}
		
		/// <summary>
		/// R111.normalized()
		/// Returns a normalized (Euclidean) element.
		/// </summary>
		public R111 normalized() { return this*(1/norm()); }
		
		
		// The basis blades
		public static R111 e0 = new R111(1f, 1);
		public static R111 e1 = new R111(1f, 2);
		public static R111 e2 = new R111(1f, 3);
		public static R111 e01 = new R111(1f, 4);
		public static R111 e02 = new R111(1f, 5);
		public static R111 e12 = new R111(1f, 6);
		public static R111 e012 = new R111(1f, 7);

		
		/// string cast
		public override string ToString()
		{
			var sb = new StringBuilder();
			var n=0;
			for (int i = 0; i < 8; ++i) 
				if (_mVec[i] != 0.0f) {
					sb.Append($"{_mVec[i]}{(i == 0 ? string.Empty : _basis[i])} + ");
					n++;
			        }
			if (n==0) sb.Append("0");
			return sb.ToString().TrimEnd(' ', '+');
		}
	}

	class Program
	{
	        

		static void Main(string[] args)
		{
		
			Console.WriteLine("e0*e0         : "+e0*e0);
			Console.WriteLine("pss           : "+e012);
			Console.WriteLine("pss*pss       : "+e012*e012);

		}
	}
}

