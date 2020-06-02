package jess;

import java.io.Serializable;

class breadth implements Strategy, Serializable
{
    public int compare(final Activation activation, final Activation activation2) {
        final int salience = activation.getSalience();
        final int salience2 = activation2.getSalience();
        if (salience != salience2) {
            return salience2 - salience;
        }
        if (activation.isInactive() && !activation2.isInactive()) {
            return -1;
        }
        if (!activation.isInactive() && activation2.isInactive()) {
            return 1;
        }
        if (activation.isInactive() && activation2.isInactive()) {
            return 0;
        }
        final Token token = activation.getToken();
        final Token token2 = activation2.getToken();
        if (token.getTime() != token2.getTime()) {
            return token.getTime() - token2.getTime();
        }
        return token.getTotalTime() - token2.getTotalTime();
    }
    
    public String getName() {
        return "breadth";
    }
}
