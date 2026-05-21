public class Slime extends Musuh implements DropItem {
    
    public Slime() {
        super("Si Lengket", 30);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " melompat dan menyemprotkan ludah! Player -15 HP");
    }

     @Override
    public void suaraKhas() {
        System.out.println(this.namaMusuh + ": " + "CUH!");
    }

    @Override
    public void dropItem() {
        System.out.println(this.namaMusuh + " menjatuhkan 1x Gel Core!");
    }
}