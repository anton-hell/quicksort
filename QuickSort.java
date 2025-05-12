import java.util.Random;

public class QuickSort {
	public static int[] arcat(int[] a, int[] b) {
		int a1 = a.length;
		int b1 = b.length;
		int c1 = a1 + b1;
		int[] c = new int[c1];
		for (int i = 0; i < c1; i++) {
			if (i < a1)
				c[i] = a[i];
			else
				c[i] = b[i - a1];
		}
		return c;
	}

	public static int[] arcut(int[] a, int l) {
		int[] o = new int[l];
		for (int i = 0; i < l; i++) {
			o[i] = a[i];
		}
		return o;
	}

	public static int[] arqs(int[] r) {
		int l = r.length;
		if (l == 1)
			return r;
		int p = r[l - 1];
		int[] pr = { p };
		int[] ar;
		int[] r1 = new int[l];
		int[] r2 = new int[l];
		int[] ar1 = null;
		int[] ar2 = null;
		int c1 = 0;
		int c2 = 0;
		boolean n1;
		boolean n2;
		for (int i = 0; i < (l - 1); i++) {
			if (r[i] <= p) {
				r1[c1] = r[i];
				c1++;
			} else {
				r2[c2] = r[i];
				c2++;
			}
		}
		n1 = c1 == 0;
		n2 = c2 == 0;
		if (!n1)
			ar1 = arqs(arcut(r1, c1));
		if (!n2)
			ar2 = arqs(arcut(r2, c2));
		ar = (!n1) ? ((!n2) ? arcat(arcat(ar1, pr), ar2) : arcat(ar1, pr)) : arcat(pr, ar2);
		return ar;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int[] r = randarr(rand, 20, 999);
		arrprint(r);
		int[] rs = arqs(r);
		arrprint(rs);
	}

	public static int[] randarr(Random rand, int l, int r) {
		int[] ar = new int[l];
		for (int i = 0; i < l; i++) {
			ar[i] = rand.nextInt(r);
		}
		return ar;
	}

	public static void arrprint(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.printf("%4d ", a[i]);
		System.out.printf("\n");
		System.out.println();
	}
}
