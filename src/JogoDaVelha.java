
// http://www.dainf.ct.utfpr.edu.br/petcoce/wp-content/uploads/2012/08/aula82.pdf
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

// criacao da interface do jogo
import javax.swing.*;
public class JogoDaVelha extends JFrame{
    JButton[] bt = new JButton[9];
    JLabel placar = new JLabel("Placar");
    // placar do jogo
    JLabel px = new JLabel("X = 0");
    JLabel po = new JLabel("O = 0");
    JLabel ro = new JLabel("Empate = 0");
    JButton novo = new JButton("Novo jogo");
    JButton zerar = new JButton("Zerar placar");
    JLabel ini = new JLabel("Jogador 'X'");
    int PX = 0;
    int PO, RO = 0;
    boolean xo = false;
    boolean in = false;
    boolean[] click = new boolean[9];
  /**
 * 
 */
// posições das variaveis a serem inseridas alem da fonte usada
public JogoDaVelha(){
    setVisible(true);
    setTitle("jogo da velha");
    setDefaultCloseOperation(3);
    setLayout(null);
    setBounds(425,150,700,500);
    setForeground(Color.BLACK);
    // botões
    add(placar);
    add(px);
    add(po);
    add(novo);
    add(zerar);// posição do placar
    add(ini);
    add(ro);
    // ola

    placar.setBounds(475,50,100,30);
    px.setBounds(425,70,100,30);
    px.setForeground(Color.RED);
    po.setBounds(475,70,100,30);
    po.setForeground(Color.BLUE);
    ro.setBounds(525,70,100,30);
    ro.setForeground(Color.ORANGE);
    novo.setBounds(425,100,140,30);
    zerar.setBounds(425,125,140,30);
    ini.setBounds(425,150,140,30);
    ini.setForeground(Color.RED);
    novo.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           limpar();
             }
        }
     );
    zerar.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           PO = 0;
           PX = 0;
           atualizar();

             }
        }
    );
// Cria os pequenos quadros onde rera inserido os "X e O"
    int cont = 0;
    for (int i=0; i < 3; i++){
        for (int j=0; j < 3; j++){
            bt[cont] = new JButton();
            add(bt[cont]);
            bt[cont].setBounds((100*i)+50,(100*j)+ 50, 95, 95);
            bt[cont].setFont(new Font("Arial", Font.BOLD,40));
            bt[cont].setBackground(new Color(200, 200, 250));
            bt[cont].setForeground(Color.white);
            // bt[cont].setBackground(Color.GREEN);
            cont++;
            
            
            
        }
    }
    for  (int i=0; i < 9; i++){
        click[i] = false;
    }

    

    bt[0].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[0] == false){
                click[0]= true;
                mudar(bt[0]);
           
             }
        }
    } );

    
    // posicao da variavel  a ser inserida "X e O"
    bt[0].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[0] == false){
                click[0]= true;
                mudar(bt[0]);
           
             }
        }
    } );
    bt[1].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[1] == false){
                click[1]= true;
                mudar(bt[1]);
           
             }
        }
    } );
    bt[2].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[2] == false){
                click[2]= true;
                mudar(bt[2]);
           
             }
        }
    } );
    bt[3].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[3] == false){
                click[3]= true;
                mudar(bt[3]);
           
             }
        }
    } );
    bt[4].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[4] == false){
                click[4]= true;
                mudar(bt[4]);
           
             }
        }
    } );
    bt[5].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[5] == false){
                click[5]= true;
                mudar(bt[5]);
           
             }
        }
    } );
    bt[6].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[6] == false){
                click[6]= true;
                mudar(bt[6]);
           
             }
        }
    } );
    bt[7].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[7] == false){
                click[7]= true;
                mudar(bt[7]);
           
             }
        }
    } );
    bt[8].addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click[8] == false){
                click[8]= true;
                mudar(bt[8]);
           
             }
        }
    } );
    
    
  } 
//   muda 1° um depois o 2°
  public void mudar(JButton btn){
    if(xo){
        btn.setText("O");
        btn.setForeground(Color.BLUE);
        ini.setForeground(Color.RED);
        ini.setText("Jogador 'X'");
        xo = false;

    }else {
        btn.setText("X");
        btn.setForeground(Color.RED);
        ini.setForeground(Color.BLUE);
        ini.setText("Jogador 'O'");
        xo = true;
    }
    // chama o metodo ganhou
    ganhou();
  }

  
// actualiza o placar
    public void atualizar(){
        px.setText("X = " + PX);
        po.setText("O = " + PO);
        ro.setText("Empate = " + RO);
    }
   

    // fução para saber quem ganhou
    public void ganhou(){
        // verifica quantos botões ja foram precionados, ate atingir os 9
        int cont = 0;
        for  (int i=0; i < 9; i++){
            if (click[i] == true){
                cont++;
        }
        }
        // botões que serao selectionados para ganhar
        // indica posicões na orizontal, diagonal e vertical
// caso o "X" ganhe
        if( (bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X") || 
            (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X") ||
            (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X") ||
            (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X") ||
            (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X") ||
            (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X") ||
            (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X") ||
            (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
            
            JOptionPane.showMessageDialog(null, "X ganhou");
            PX++;
            atualizar();
            // chama a fução limpar
            limpar();
// caso o "O" ganhe
        }else if( (bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O") || 
                (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O") ||
                (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O") ||
                (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O") ||
                (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O") ||
                (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O") ||
                (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O") ||
                (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
        
        JOptionPane.showMessageDialog(null, "O ganhou");
        PO++;
        atualizar();
        // chama a fução limpar
        limparo();

    }else if(cont == 9){
        RO++;
        atualizar();
        JOptionPane.showMessageDialog(null, "Empate");
         // chama a fução limpar
        limparo();

    }
    }

    // para limpar 
    public void limpar(){

        ini.setForeground(Color.RED);
        ini.setText("Jogador 'X'");

        for  (int i=0; i < 9; i++){
            bt[i].setText("");
            click[i] = false;
            xo = false;
        }

    }
    public void limparo(){

        ini.setForeground(Color.BLUE);
        ini.setText("Jogador 'O'");

        for  (int i=0; i < 9; i++){
            bt[i].setText("");
            click[i] = false;
            xo = true;
        }

    }
    public static void main(String[] args) {
      new JogoDaVelha();

    }
}