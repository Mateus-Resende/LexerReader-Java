package core;

public class TokenReader implements Runnable {

    public static void main(String[] args) {
        (new Thread(new TokenReader())).start();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String id = "$";
        String hex = "ABCDEF";
        String real = ",";
        String chain = "\"";
        String op = "+-%&|=";
        String opMult = "*";

        Token t = new Token("+  %  ");
        int state = 0;

        while (t.hasNext()) {
            Character c = t.next();

            switch (state) {
                case 0:
                    System.out.println("######################");
                    System.out.println("Estado inicial");
                    System.out.println("######################");

                    if (c.equals(id))
                        state = 1;
                    else if (Character.isDigit(c))
                        state = 4;
                    else if (c.equals(chain))
                        state = 8;
                    else if (op.contains(c.toString()))
                        state = 10;
                    else if (opMult.equals(c.toString()))
                        state = 11;

                    break;

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                case 12:
                    break;

                default:
                    break;
            }
        }
    }
}
