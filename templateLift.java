import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class templateLift{
    private int lantaiTujuanKosong = 15;
    
    // untuk menerima input
    public Scanner isiLantai = new Scanner(System.in);
    private String isiTujuan;

    // Variabel untuk menciptakan arrayList dengan elemen unik
    private HashSet<Integer> setTujuan = new HashSet<>();
    private ArrayList<Integer> tujuan = new ArrayList<>();
    private String stringTujuan;

    private int jumlahOrang;
    private int indeksLantai = 0;
    private String listLantai[] = {"Lantai 1", "Lantai 2", "Lantai 3", "Lantai 4", "Lantai 5",
                                    "Lantai 6", "Lantai 7", "Lantai 8", "Lantai 9", "Lantai 10",
                                    "Lantai 11", "Lantai 12", "Lantai 13", "Lantai 14", "Lantai 15"
                                    }; 
    private String posisi;
    
    // Creating regex pattern
    // private Pattern cekInput = Pattern.compile([0-15]);
    private String rangeLantai = "^(1[0-5]|[1-9])$";  // untuk regex range [0-15]
    private Pattern cekLantai = Pattern.compile(rangeLantai);


    // Untuk menghitung jumlah penumpang dengan lantai tujuannya
    private HashMap<String, Integer> tujuanDanJumlahOrang = new HashMap<String, Integer>();
    
    // Constructor
    templateLift(){

        this.posisi = listLantai[indeksLantai];

        this.jumlahOrang = 0;

        // Set default Lantai Tujuan
        this.tujuanDanJumlahOrang.put("Lantai 1", 0);
        this.tujuanDanJumlahOrang.put("Lantai 2", 0);
        this.tujuanDanJumlahOrang.put("Lantai 3", 0);
        this.tujuanDanJumlahOrang.put("Lantai 4", 0);
        this.tujuanDanJumlahOrang.put("Lantai 5", 0);
        this.tujuanDanJumlahOrang.put("Lantai 6", 0);
        this.tujuanDanJumlahOrang.put("Lantai 7", 0);
        this.tujuanDanJumlahOrang.put("Lantai 8", 0);
        this.tujuanDanJumlahOrang.put("Lantai 9", 0);
        this.tujuanDanJumlahOrang.put("Lantai 10", 0);
        this.tujuanDanJumlahOrang.put("Lantai 11", 0);
        this.tujuanDanJumlahOrang.put("Lantai 12", 0);
        this.tujuanDanJumlahOrang.put("Lantai 13", 0);
        this.tujuanDanJumlahOrang.put("Lantai 14", 0);
        this.tujuanDanJumlahOrang.put("Lantai 15", 0);

    }
    
    // Penumpang 
        // Penumpang naik
        protected void tambahPenumpang() {
            // melakukan perulangan sebanyak jumlah penumpang baru
            int indeksReqPenumpang = 0;
            System.out.print("[??] Berapa penumpang ? ");
            String jumlahPenumpangBaru = isiLantai.next();
            
            // exit
            if(jumlahPenumpangBaru.equals("exit")) this.tutup();

            //perulangan mengisi memilih lantai untuk tiap penumpang
            while (indeksReqPenumpang < Integer.parseInt(jumlahPenumpangBaru)){
                
                System.out.print("\n[??] Pilih lantai tujuan [1-15] -> ");
                this.isiTujuan = isiLantai.next();

                // Cek Input Lantai ada/tidak
                if (cekLantai.matcher(this.isiTujuan).find() && this.getPosisi() != toPosisi(isiTujuan)){
                    printProgressBar("[++] Menambahkan orang ke-"+(indeksReqPenumpang+1), 30, 25);
                    this.jumlahOrang += 1;
                    // menambahkan jumlah orang dengan tujuan yang sama
                    this.updateGoalsMember(isiTujuan);  
                    // menambahkan nilai pada tujuan lift secara unik
                    // Kondisi menambah penumpang
                    if (this.setTujuan.add(Integer.parseInt(isiTujuan))){
                        this.tujuan.add(Integer.parseInt(isiTujuan));
                    }

                    // supaya bisa berhenti loop
                    indeksReqPenumpang++;
                }

                // exit
                else if(this.isiTujuan.equals("exit")) this.tutup();
                
                // jika lantai tujuan tidak valid
                else{ 
                    System.out.println("[!!] Lantai tidak valid"); 
                    System.out.println("[->] Masukan ulang lantai tujuan !!!");
                }
                
            }
            this.clearConsole();
        }

        // Update isi penumpang sesuai tujuan
        private void updateGoalsMember(String isiTujuan){
            if (isiTujuan.equals("1")){
                this.tujuanDanJumlahOrang.put("Lantai 1", this.tujuanDanJumlahOrang.get("Lantai 1")+1);
            }
            else if (isiTujuan.equals("2")){
                this.tujuanDanJumlahOrang.put("Lantai 2", this.tujuanDanJumlahOrang.get("Lantai 2")+1);
            }
            else if (isiTujuan.equals("3")){
                this.tujuanDanJumlahOrang.put("Lantai 3", this.tujuanDanJumlahOrang.get("Lantai 3")+1);
            }
            else if (isiTujuan.equals("4")){
                this.tujuanDanJumlahOrang.put("Lantai 4", this.tujuanDanJumlahOrang.get("Lantai 4")+1);
            }
            else if (isiTujuan.equals("5")){
                this.tujuanDanJumlahOrang.put("Lantai 5", this.tujuanDanJumlahOrang.get("Lantai 5")+1);
            }
            else if (isiTujuan.equals("6")){
                this.tujuanDanJumlahOrang.put("Lantai 6", this.tujuanDanJumlahOrang.get("Lantai 6")+1);
            }
            else if (isiTujuan.equals("7")){
                this.tujuanDanJumlahOrang.put("Lantai 7", this.tujuanDanJumlahOrang.get("Lantai 7")+1);
            }
            else if (isiTujuan.equals("8")){
                this.tujuanDanJumlahOrang.put("Lantai 8", this.tujuanDanJumlahOrang.get("Lantai 8")+1);
            }
            else if (isiTujuan.equals("9")){
                this.tujuanDanJumlahOrang.put("Lantai 9", this.tujuanDanJumlahOrang.get("Lantai 9")+1);
            }
            else if (isiTujuan.equals("10")){
                this.tujuanDanJumlahOrang.put("Lantai 10", this.tujuanDanJumlahOrang.get("Lantai 10")+1);
            }
            else if (isiTujuan.equals("11")){
                this.tujuanDanJumlahOrang.put("Lantai 11", this.tujuanDanJumlahOrang.get("Lantai 11")+1);
            }
            else if (isiTujuan.equals("12")){
                this.tujuanDanJumlahOrang.put("Lantai 12", this.tujuanDanJumlahOrang.get("Lantai 12")+1);
            }
            else if (isiTujuan.equals("13")){
                this.tujuanDanJumlahOrang.put("Lantai 13", this.tujuanDanJumlahOrang.get("Lantai 13")+1);
            }
            else if (isiTujuan.equals("14")){
                this.tujuanDanJumlahOrang.put("Lantai 14", this.tujuanDanJumlahOrang.get("Lantai 14")+1);
            }
            else if (isiTujuan.equals("15")){
                this.tujuanDanJumlahOrang.put("Lantai 15", this.tujuanDanJumlahOrang.get("Lantai 15")+1);
            }      
        } 
   
        // Penumpang turun
        private void turunPenumpang() {
        // mengurangi penumpang dan mengupdate jumlah orang berdasakan lantai tujuan
        System.out.println("[>] Penumpang turun ... \n[--] Muatan berkurang " + this.tujuanDanJumlahOrang.get(this.getPosisi()) + " orang");
        this.jumlahOrang -= this.tujuanDanJumlahOrang.get(this.getPosisi());
        this.tujuanDanJumlahOrang.put(this.getPosisi(), 0);
        this.setTujuan.remove(this.getNumOfLantai(getPosisi()));
        this.rmArrayListElement();
        }

        // Method menghapus Array spesifik dengan elemennya
        private void rmArrayListElement(){
            // mencari index posisi 
            int indeksRemove;
            for(indeksRemove = 0; indeksRemove < this.tujuan.size(); indeksRemove++){
                // Convert Tujuan
                this.convertTujuan(indeksRemove);
                // break if index number stored
                if (this.stringTujuan == this.getPosisi()){
                    break;
                }
            }
            this.tujuan.remove(indeksRemove);
            // System.out.println("Jumlah orang : "+this.isiLift());

        }

        

    // Update Posisi (bergerak)
        private void goUp(){
            this.indeksLantai += 1;
            this.posisi = this.listLantai[indeksLantai];
            // System.out.println("Lift bergerak naik ...");
            this.printProgressBar("Lift bergerak naik ...", 30, 10);
        }

        private void goDown(){
            this.indeksLantai -= 1;
            this.posisi = this.listLantai[indeksLantai];
            // System.out.println("Lift bergerak turun ...");
            this.printProgressBar("Lift bergerak turun ...", 30, 10);
        }

        protected void move(){
            // jika ga ada penumpang -> menelusuri setiap lantai
            if (this.tujuan.size() == 0) {
                if (this.lantaiTujuanKosong > this.getNumOfLantai(this.posisi)) this.goUp();
                else if (this.lantaiTujuanKosong < this. getNumOfLantai(this.posisi)) this.goDown();
            } 

            // jika ada penumpang
            // jika lantai dibawah (ex : 1 < tujuan) maka naik
            else if (this.tujuan.get(0) > this.getNumOfLantai(this.posisi)) this.goUp();
            // sebaliknya
            else if (this.tujuan.get(0) < this.getNumOfLantai(this.posisi)) this.goDown();
        
            // Kurangi penumpang ketika sampai tujuan
            for (int i = 0; i < this.tujuan.size(); i++)
            {
                this.convertTujuan(i);
                if (this.getPosisi() == this.stringTujuan){
                    turunPenumpang();
                }
            }
            
            // update tujuan untuk tidak ada penumpaang
            if      (this.posisi.equals("Lantai 15")) this.lantaiTujuanKosong = 0;
            else if (this.posisi.equals("Lantai 1")) this.lantaiTujuanKosong = 15;

        }


    // Converter    
        // Mencari integer dari posisi (ex: Lantai 1 -> 1)
        private int getNumOfLantai(String posisi){
            int value = 0;
            
            if      (posisi == "Lantai 1" ) value = 1 ;
            else if (posisi == "Lantai 2" ) value = 2 ;
            else if (posisi == "Lantai 3" ) value = 3 ;
            else if (posisi == "Lantai 4" ) value = 4 ;
            else if (posisi == "Lantai 5" ) value = 5 ;
            else if (posisi == "Lantai 6" ) value = 6 ;
            else if (posisi == "Lantai 7" ) value = 7 ;
            else if (posisi == "Lantai 8" ) value = 8 ;
            else if (posisi == "Lantai 9" ) value = 9 ;
            else if (posisi == "Lantai 10") value = 10;
            else if (posisi == "Lantai 11") value = 11;
            else if (posisi == "Lantai 12") value = 12;
            else if (posisi == "Lantai 13") value = 13;
            else if (posisi == "Lantai 14") value = 14;
            else if (posisi == "Lantai 15") value = 15;
            
            return value;
        }
        
        // Convert ArrayList<Integer> -> String lantai
        void convertTujuan(int indeksRemove){
            if      (this.tujuan.get(indeksRemove) == 1 ) this.stringTujuan = "Lantai 1" ;
            else if (this.tujuan.get(indeksRemove) == 2 ) this.stringTujuan = "Lantai 2" ;
            else if (this.tujuan.get(indeksRemove) == 3 ) this.stringTujuan = "Lantai 3" ;
            else if (this.tujuan.get(indeksRemove) == 4 ) this.stringTujuan = "Lantai 4" ;
            else if (this.tujuan.get(indeksRemove) == 5 ) this.stringTujuan = "Lantai 5" ;
            else if (this.tujuan.get(indeksRemove) == 6 ) this.stringTujuan = "Lantai 6" ;
            else if (this.tujuan.get(indeksRemove) == 7 ) this.stringTujuan = "Lantai 7" ;
            else if (this.tujuan.get(indeksRemove) == 8 ) this.stringTujuan = "Lantai 8" ;
            else if (this.tujuan.get(indeksRemove) == 9 ) this.stringTujuan = "Lantai 9" ;
            else if (this.tujuan.get(indeksRemove) == 10) this.stringTujuan = "Lantai 10";
            else if (this.tujuan.get(indeksRemove) == 11) this.stringTujuan = "Lantai 11";
            else if (this.tujuan.get(indeksRemove) == 12) this.stringTujuan = "Lantai 12";
            else if (this.tujuan.get(indeksRemove) == 13) this.stringTujuan = "Lantai 13";
            else if (this.tujuan.get(indeksRemove) == 14) this.stringTujuan = "Lantai 14";
            else if (this.tujuan.get(indeksRemove) == 15) this.stringTujuan = "Lantai 15";
        }
    
        // String angka(x) -> Posisi "Lantai x"
        private String toPosisi(String tujuan){
            String value = "";
            if      (tujuan.equals("1"))  value = "Lantai 1";
            else if (tujuan.equals("2"))  value = "Lantai 2";
            else if (tujuan.equals("3"))  value = "Lantai 3";
            else if (tujuan.equals("4"))  value = "Lantai 4";
            else if (tujuan.equals("5"))  value = "Lantai 5";
            else if (tujuan.equals("6"))  value = "Lantai 6";
            else if (tujuan.equals("7"))  value = "Lantai 7";
            else if (tujuan.equals("8"))  value = "Lantai 8";
            else if (tujuan.equals("9"))  value = "Lantai 9";
            else if (tujuan.equals("10")) value = "Lantai 10";
            else if (tujuan.equals("11")) value = "Lantai 11";
            else if (tujuan.equals("12")) value = "Lantai 12";
            else if (tujuan.equals("13")) value = "Lantai 13";
            else if (tujuan.equals("14")) value = "Lantai 14";
            else if (tujuan.equals("15")) value = "Lantai 15";

            return value;
        }
 
    // Getter
        // getter Posisi
        public String getPosisi(){
            return this.posisi;
        }

        // getter IsiLift
        protected String isiLift(){
            return "["+ this.jumlahOrang+"]";
        }

        // getter list tujuan
        ArrayList<Integer> getTujuan(){
            return tujuan;
        }

    
    // Print Info
        // get information tujuanDanJumlahOrang
        // menampilkan info jumlah orang sesuai lantai tujuan
        private void tujuanDanJumlahOrang(){
            System.out.println("[>] Tujuan Lantai 1 \t:"+tujuanDanJumlahOrang.get("Lantai 1")+" Orang");
            System.out.println("[>] Tujuan Lantai 2 \t:"+tujuanDanJumlahOrang.get("Lantai 2")+" Orang");
            System.out.println("[>] Tujuan Lantai 3 \t:"+tujuanDanJumlahOrang.get("Lantai 3")+" Orang");
            System.out.println("[>] Tujuan Lantai 4 \t:"+tujuanDanJumlahOrang.get("Lantai 4")+" Orang");
            System.out.println("[>] Tujuan Lantai 5 \t:"+tujuanDanJumlahOrang.get("Lantai 5")+" Orang");
            System.out.println("[>] Tujuan Lantai 6 \t:"+tujuanDanJumlahOrang.get("Lantai 6")+" Orang");
            System.out.println("[>] Tujuan Lantai 7 \t:"+tujuanDanJumlahOrang.get("Lantai 7")+" Orang");
            System.out.println("[>] Tujuan Lantai 8 \t:"+tujuanDanJumlahOrang.get("Lantai 8")+" Orang");
            System.out.println("[>] Tujuan Lantai 9 \t:"+tujuanDanJumlahOrang.get("Lantai 9")+" Orang");
            System.out.println("[>] Tujuan Lantai 10 \t:"+tujuanDanJumlahOrang.get("Lantai 10")+" Orang");
            System.out.println("[>] Tujuan Lantai 11 \t:"+tujuanDanJumlahOrang.get("Lantai 11")+" Orang");
            System.out.println("[>] Tujuan Lantai 12 \t:"+tujuanDanJumlahOrang.get("Lantai 12")+" Orang");
            System.out.println("[>] Tujuan Lantai 13 \t:"+tujuanDanJumlahOrang.get("Lantai 13")+" Orang");
            System.out.println("[>] Tujuan Lantai 14 \t:"+tujuanDanJumlahOrang.get("Lantai 14")+" Orang");
            System.out.println("[>] Tujuan Lantai 15 \t:"+tujuanDanJumlahOrang.get("Lantai 15")+" Orang");
        }

        // menampilkan informasi
        protected void getInfo(){
            System.out.println("* ============== INFORMASI ============== *");
            System.out.println("[->] Jumlah Orang \t: " + this.isiLift());
            System.out.println("[->] Posisi \t\t: " + this.getPosisi());
            System.out.println("[->] Antrian Tujuan \t: " + this.getTujuan());
            System.out.println("* ======================================= *");
            this.tujuanDanJumlahOrang();
            System.out.println("* ======================================= *\n");
        }


    // Additional
        // clear console 
        public void clearConsole(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        // Method Progress Bar
        public void printProgressBar(String message, int length, long timeInterval)
        {
            char incomplete = '.'; // U+2591 Unicode Character
            char complete = '█'; // U+2588 Unicode Character
            StringBuilder builder = new StringBuilder();
            Stream.generate(() -> incomplete).limit(length).forEach(builder::append);
            System.out.println(message);
            for(int i = 0; i < length; i++)
            {
                builder.replace(i,i+1,String.valueOf(complete));
                String progressBar = "\r"+builder;
                System.out.print(progressBar);
                try
                {
                    Thread.sleep(timeInterval);
                    // TimeUnit.SECONDS.sleep(timeInterval);
                }
                catch (InterruptedException ignored)
                {

                }
            }
            System.out.println("\n");
        }

        // untuk keluar program -> command exit
        public void tutup(){
        this.clearConsole();
        this.printProgressBar("[->] Keluar Program...", 50, 20);
        System.out.println("[Program Berhenti Disini] -> exit command.");
        this.printProgressBar("\n[->] Menutup Program ...", 50, 20);
        System.exit(0);
    }
}
