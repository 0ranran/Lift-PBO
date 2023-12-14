import java.util.regex.Pattern;


final class Lift  extends templateLift implements interfaceLift{

    // regex case insensitive untuk cek yes/no
    private Pattern isIya = Pattern.compile("y", Pattern.CASE_INSENSITIVE);
    
    // constructor, hanya mengambil dari superclass
    Lift(){
        super();
    }

    @Override
    protected void getInfo() {
        super.getInfo();
        this.sketsa();
    }

    public void start(){
        printProgressBar("[info] Menjalankan applikasi lift...", 50, 15);
        clearConsole();

        while(true){
            this.getInfo();
            this.apaAdaOrang();
            this.move();
        }
    }

    // cek ada penumpang naik / tidak
    protected void apaAdaOrang(){
        System.out.print("Ada orang (y/n)? ");
        String input = isiLantai.next();
        

        if (isIya.matcher(input).find()) {
            this.tambahPenumpang();
        }

        // void exit -> keluar program
        else if (input.equals("exit")) this.tutup();
        
        // selain ya, clear console -> bergerak
        else {
            this.clearConsole();
        }
        }

    // sketsa lift
    public void sketsa(){
        System.out.println("       [~] SKETSA [~] ");
        if(this.getPosisi().equals("Lantai 1")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 5   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 4   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 3   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 2   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 1   || "+this.isiLift()+" \\\\");
            System.out.println("====================== *");
        }

        else if(this.getPosisi().equals("Lantai 2")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 5   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 4   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 3   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 2   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 1   ||     \\\\");
            System.out.println("====================== *");
        }

        else if(this.getPosisi().equals("Lantai 3")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 5   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 4   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 3   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 2   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 1   ||     \\\\");
            System.out.println("====================== *");
        }

        else if(this.getPosisi().equals("Lantai 4")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 5   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 4   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 3   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 2   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 1   ||     \\\\");
            System.out.println("====================== *");
        }

        else if(this.getPosisi().equals("Lantai 5")){
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 5   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 4   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 3   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 2   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 1   ||     \\\\");
            System.out.println("====================== *");
        }

        else if(this.getPosisi().equals("Lantai 10")){
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 10  || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 9   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 8   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 7   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 6   ||     \\\\");
            System.out.println("        ||     ||------ *");
        }

        else if(this.getPosisi().equals("Lantai 9")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 10  ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 9   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 8   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 7   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 6   ||     \\\\");
            System.out.println("        ||     ||------ *");
        }
        else if(this.getPosisi().equals("Lantai 8")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 10  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 9   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 8   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 7   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 6   ||     \\\\");
            System.out.println("        ||     ||------ *");
        }

        else if(this.getPosisi().equals("Lantai 7")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 10  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 9   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 8   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 7   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 6   ||     \\\\");
            System.out.println("        ||     ||------ *");
        }

        else if(this.getPosisi().equals("Lantai 6")){
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 10  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 9   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 8   ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 7   ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 6   || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
        }

        else if(this.getPosisi().equals("Lantai 11")){
            System.out.println("           + ========= *");
            System.out.println("          // \\\\ \\\\ \\\\  *");
            System.out.println("         // \\\\ \\\\ \\\\   *");
            System.out.println("        + ============ *");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 15  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 14  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 13  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 12  ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 11  || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
        }

        else if(this.getPosisi().equals("Lantai 12")){
            System.out.println("           + ========= *");
            System.out.println("          // \\\\ \\\\ \\\\  *");
            System.out.println("         // \\\\ \\\\ \\\\   *");
            System.out.println("        + ============ *");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 15  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 14  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 13  ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 12  || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 11  ||     \\\\");
            System.out.println("        ||     ||------ *");
        }        

        else if(this.getPosisi().equals("Lantai 13")){
            System.out.println("           + ========= *");
            System.out.println("          // \\\\ \\\\ \\\\  *");
            System.out.println("         // \\\\ \\\\ \\\\   *");
            System.out.println("        + ============ *");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 15  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 14  ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 13  || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 12  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 11  ||     \\\\");
            System.out.println("        ||     ||------ *");
        }                

        else if(this.getPosisi().equals("Lantai 14")){
            System.out.println("           + ========= *");
            System.out.println("          // \\\\ \\\\ \\\\  *");
            System.out.println("         // \\\\ \\\\ \\\\   *");
            System.out.println("        + ============ *");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 15  ||     \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 14  || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 13  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 12  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 11  ||     \\\\");
            System.out.println("        ||     ||------ *");
        }                

        else if(this.getPosisi().equals("Lantai 15")){
            System.out.println("           + ========= *");
            System.out.println("          // \\\\ \\\\ \\\\  *");
            System.out.println("         // \\\\ \\\\ \\\\   *");
            System.out.println("        + ============ *");
            System.out.println("Lt. 15  || "+this.isiLift()+" \\\\");
            System.out.println("        ||=====||------ *");
            System.out.println("Lt. 14  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 13  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 12  ||     \\\\");
            System.out.println("        ||     ||------ *");
            System.out.println("Lt. 11  ||     \\\\");
            System.out.println("        ||     ||------ *");
        }                
        
        else System.out.println("belum ada sketsa");

    }


}
