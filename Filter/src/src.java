import java.io.*;

public class src {

	public static void main(String args[]) {
		int num_fil = Integer.parseInt(args[0]);
		String filtered = args[1];
		String fullgene = args[2];
		String newfiledir = args[3];
		System.out.println(num_fil+filtered+fullgene+newfiledir);
		try {
			FileReader fr = new FileReader(filtered);
			BufferedReader br = new BufferedReader(fr);
			String mat[][] = new String[num_fil][2];
			br.readLine();
			String ln = br.readLine();
			int line = 0;
			while(ln !=null) {
				mat[line][0] = ln.split("\t")[0];
				mat[line][1] = ln;
				line++;
				ln = br.readLine();
			}
			br.close();
			fr.close();
			System.out.println("Filtered reading complete!!");
			fr = new FileReader(fullgene);
			br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(newfiledir);
			BufferedWriter bw = new BufferedWriter(fw);
			br.readLine();
			ln = br.readLine();
			String temp;
			while(ln!=null) {
				temp = ln.split("\t")[0];
				for(int i =0;i<line;i++) {
					if(mat[i][0].equals(temp)) {
						bw.write(ln+"\n");
						System.out.println(mat[i][0]);
						break;
					}
				}
				ln = br.readLine();
				
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("\n*********Input Format**********\njava -jar"
					+ "\nmyJar.jar"
					+ "\nNumber_of_filtered_genes"
					+ "\n/dir/filteredfile"
					+ "\n/dir/Wholefile"
					+ "\n/dir/outputfile\n\n");
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\nNumber_of_filtered_genes is not correct!! : " + num_fil+"\n");
		}
	}
}
