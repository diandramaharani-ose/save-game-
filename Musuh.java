import java.io.Serializable;

public abstract class Musuh implements Serializable {
    protected String namaMusuh;
    protected int healthPoint;

    public Musuh(String nama, int hp) {
        this.namaMusuh = nama;
        this.healthPoint = hp;
    }

    public void terimaDamage(int damage) {
        if (this.healthPoint <= 0) {
            return;
        }
        
        this.healthPoint -= damage;
        
        if (this.healthPoint < 0) {
            this.healthPoint = 0;
        }

        System.out.println(this.namaMusuh + " terkena serangan! Sisa HP: " + this.healthPoint);
        }
        
    public abstract void serangPemain();
    public abstract void suaraKhas();
}