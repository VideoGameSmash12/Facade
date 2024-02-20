package facade.characters.wmedef;

import wm.WME;

public class ConverseStagingWME extends WME
{
    private boolean bGraceOnLeft;
    private boolean bIsGraceConverseStaging;
    private boolean bIsTripConverseStaging;
    private float graceWalkToX;
    private float graceWalkToY;
    private float graceWalkToZ;
    private float graceWalkToRotY;
    private float tripWalkToX;
    private float tripWalkToY;
    private float tripWalkToZ;
    private float tripWalkToRotY;
    
    public synchronized boolean getBGraceOnLeft() {
        return this.bGraceOnLeft;
    }
    
    public synchronized boolean getBIsGraceConverseStaging() {
        return this.bIsGraceConverseStaging;
    }
    
    public synchronized boolean getBIsTripConverseStaging() {
        return this.bIsTripConverseStaging;
    }
    
    public synchronized float getGraceWalkToX() {
        return this.graceWalkToX;
    }
    
    public synchronized float getGraceWalkToY() {
        return this.graceWalkToY;
    }
    
    public synchronized float getGraceWalkToZ() {
        return this.graceWalkToZ;
    }
    
    public synchronized float getGraceWalkToRotY() {
        return this.graceWalkToRotY;
    }
    
    public synchronized float getTripWalkToX() {
        return this.tripWalkToX;
    }
    
    public synchronized float getTripWalkToY() {
        return this.tripWalkToY;
    }
    
    public synchronized float getTripWalkToZ() {
        return this.tripWalkToZ;
    }
    
    public synchronized float getTripWalkToRotY() {
        return this.tripWalkToRotY;
    }
    
    public synchronized void setBGraceOnLeft(final boolean bGraceOnLeft) {
        this.bGraceOnLeft = bGraceOnLeft;
    }
    
    public synchronized void setBIsGraceConverseStaging(final boolean bIsGraceConverseStaging) {
        this.bIsGraceConverseStaging = bIsGraceConverseStaging;
    }
    
    public synchronized void setBIsTripConverseStaging(final boolean bIsTripConverseStaging) {
        this.bIsTripConverseStaging = bIsTripConverseStaging;
    }
    
    public synchronized void setGraceWalkToX(final float graceWalkToX) {
        this.graceWalkToX = graceWalkToX;
    }
    
    public synchronized void setGraceWalkToY(final float graceWalkToY) {
        this.graceWalkToY = graceWalkToY;
    }
    
    public synchronized void setGraceWalkToZ(final float graceWalkToZ) {
        this.graceWalkToZ = graceWalkToZ;
    }
    
    public synchronized void setGraceWalkToRotY(final float graceWalkToRotY) {
        this.graceWalkToRotY = graceWalkToRotY;
    }
    
    public synchronized void setTripWalkToX(final float tripWalkToX) {
        this.tripWalkToX = tripWalkToX;
    }
    
    public synchronized void setTripWalkToY(final float tripWalkToY) {
        this.tripWalkToY = tripWalkToY;
    }
    
    public synchronized void setTripWalkToZ(final float tripWalkToZ) {
        this.tripWalkToZ = tripWalkToZ;
    }
    
    public synchronized void setTripWalkToRotY(final float tripWalkToRotY) {
        this.tripWalkToRotY = tripWalkToRotY;
    }
    
    public ConverseStagingWME(final boolean bGraceOnLeft) {
        this.bGraceOnLeft = bGraceOnLeft;
        this.bIsGraceConverseStaging = false;
        this.bIsTripConverseStaging = false;
        this.graceWalkToX = 0.0f;
        this.graceWalkToY = 0.0f;
        this.graceWalkToZ = 0.0f;
        this.graceWalkToRotY = 0.0f;
        this.tripWalkToX = 0.0f;
        this.tripWalkToY = 0.0f;
        this.tripWalkToZ = 0.0f;
        this.tripWalkToRotY = 0.0f;
    }
}
