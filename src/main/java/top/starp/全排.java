package top.starp;

//import javax.sound.midi.VoiceStatus;

public class 全排 {
	int n;
	int[] a;
	boolean xuan[];

	void swap(int i, int j) {
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

	void dfs(int m) {
		if (m > n) {
			System.out.println(a);
		}
		for (int i = m; i < n; i++) {
			swap(i, m);
			dfs(m + 1);
			swap(i, m);

		}
	}

	void dfs1(int cnt, int pos) {
		if (cnt > n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (xuan[i]) {
					sum += a[i];
				}
			}
			return;
		}
		for (int i = pos; i < n; i++) {
			if (!xuan[i]) {
				xuan[i] = true;
				dfs1(cnt + 1, pos + 1);
				xuan[i] = false;
			}
		}
	}

	void dfs2(int pos) {
		if (pos >= n) {
			for (int i = 0; i < n; i++) {
				if (xuan[i]) {
					System.out.println(a[i]);
				}
			}
		}
		for (int i = pos; i < n; i++) {
			if (!xuan[i]) {
				xuan[i] = true;
				dfs(pos + 1);
				xuan[i] = false;
			}
		}
	}

	void dfsXuan(int pos) {
		if(pos>=n) {
			for (int i = 0; i <n; i++) {
				if(xuan[i]) {

				}
			}
		}
		for (int i = pos; i < a.length; i++) {
			if(!xuan[i]) {
				xuan[i]=true;
				dfsXuan(pos+1);
				xuan[i]=false;
			}
		}
	}

	void dfs3(int pos) {
		if(pos>=n) {

		}
		for (int i = pos; i < a.length; i++) {
			swap(i, pos);
			dfs3(pos+1);
			swap(i, pos);
		}
	}
}
