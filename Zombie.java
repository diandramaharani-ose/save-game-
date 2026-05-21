public class Zombie extends Musuh implements DropItem {

    public Zombie() {
        super("Zombie Toxic Kisser", 80);
    }
    
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " mencium brutal! -15 HP");
    } 

    @Override
    public void suaraKhas() {
        System.out.println(this.namaMusuh + ": " + "CUP! Muachh SROOOTTTT!");
    } 

    @Override
    public void dropItem() {
        System.out.println(this.namaMusuh + " menjatuhkan 1x Rotten Soul (EPIC)!");
    }
}