public class Naga extends Musuh implements BisaTerbang, DropItem {
    public Naga() {
        super("Naga Diare", 500);
    }

    @Override
    public void serangPemain() {
        System.out.println(namaMusuh + " mengeluarkan nafas! Player -50 HP");
    }

    @Override
    public void suaraKhas() {
        System.out.println(this.namaMusuh + ": " + "PRRROOOOOOOTTTTTTT");
    }

    @Override 
    public void lepasLandas() {
        System.out.println(this.namaMusuh + " terbang tinggi! Sulit diserang.");
    }

    @Override
    public void seranganUdara() {
        System.out.println(this.namaMusuh + " menyemburkan kentut berdahak! Pemain -80 HP.");
    }

    @Override
    public void dropItem() {
        System.out.println(this.namaMusuh + " menjatuhkan 3x Eye of Disaster (LEGENDARY)!");
    }
}