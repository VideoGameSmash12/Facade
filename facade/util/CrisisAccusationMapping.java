package facade.util;

import java.util.LinkedList;

public class CrisisAccusationMapping implements SpriteID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations
{
    public static CrisisAccusationMapping mapping;
    public static LinkedList accList;
    public static LinkedList accMapList;
    
    public void AddAccusationMapping(final int pcType, final int pcParam, final int buggedChr, final int chrToSpeak, final int accusationID1, final int accusationID2) {
        final CrisisAccusationMappingElement crisisAccusationMappingElement = new CrisisAccusationMappingElement();
        crisisAccusationMappingElement.pcType = pcType;
        crisisAccusationMappingElement.pcParam = pcParam;
        crisisAccusationMappingElement.buggedChr = buggedChr;
        crisisAccusationMappingElement.chrToSpeak = chrToSpeak;
        crisisAccusationMappingElement.accusationID1 = accusationID1;
        crisisAccusationMappingElement.accusationID2 = accusationID2;
        CrisisAccusationMapping.accMapList.add(crisisAccusationMappingElement);
    }
    
    public void AddAccusation(final int accusationID, final int backstoryCategory, final int chrToSpeak, final int dialogToSpeak) {
        final CrisisAccusation crisisAccusation = new CrisisAccusation();
        crisisAccusation.accusationID = accusationID;
        crisisAccusation.backstoryCategory = backstoryCategory;
        crisisAccusation.chrToSpeak = chrToSpeak;
        crisisAccusation.dialogToSpeak = dialogToSpeak;
        CrisisAccusationMapping.accList.add(crisisAccusation);
    }
    
    public int ChooseAccusation(final int n, final int n2, final int n3) {
        return this.ChooseAccusation(n, n2, n3, true);
    }
    
    public int ChooseAccusation(final int n, final int n2, final int n3, final boolean b) {
        for (int i = 0; i < CrisisAccusationMapping.accMapList.size(); ++i) {
            final CrisisAccusationMappingElement crisisAccusationMappingElement = CrisisAccusationMapping.accMapList.get(i);
            if (crisisAccusationMappingElement.pcType == n && crisisAccusationMappingElement.pcParam == n2 && crisisAccusationMappingElement.chrToSpeak == n3) {
                for (int j = 0; j < CrisisAccusationMapping.accList.size(); ++j) {
                    final CrisisAccusation crisisAccusation = CrisisAccusationMapping.accList.get(j);
                    if (crisisAccusation.accusationID == crisisAccusationMappingElement.accusationID1 && !crisisAccusation.bSpoken) {
                        if (b) {
                            crisisAccusation.bSpoken = true;
                        }
                        return crisisAccusationMappingElement.accusationID1;
                    }
                }
                for (int k = 0; k < CrisisAccusationMapping.accList.size(); ++k) {
                    final CrisisAccusation crisisAccusation2 = CrisisAccusationMapping.accList.get(k);
                    if (crisisAccusation2.accusationID == crisisAccusationMappingElement.accusationID2 && !crisisAccusation2.bSpoken) {
                        if (b) {
                            crisisAccusation2.bSpoken = true;
                        }
                        return crisisAccusationMappingElement.accusationID2;
                    }
                }
            }
        }
        StringUtil.println("### ChooseAccusation could not find an unspoken accusation that matched pcType " + n + " pcParam " + n2 + " chrToSpeak " + n3);
        if (n3 == 0) {
            return 0;
        }
        return 80;
    }
    
    public boolean DidBCAccusationOccur(final int n) {
        for (int i = 0; i < CrisisAccusationMapping.accList.size(); ++i) {
            final CrisisAccusation crisisAccusation = CrisisAccusationMapping.accList.get(i);
            if (crisisAccusation.backstoryCategory == n && crisisAccusation.bSpoken) {
                return true;
            }
        }
        return false;
    }
    
    public CrisisAccusationMapping() {
        (CrisisAccusationMapping.mapping = this).AddAccusationMapping(6, 100, -1, 0, 0, 42);
        this.AddAccusationMapping(6, 100, -1, 1, 80, 44);
        this.AddAccusationMapping(6, 101, -1, 0, 40, 42);
        this.AddAccusationMapping(6, 101, -1, 1, 60, 44);
        this.AddAccusationMapping(6, 208, -1, 0, 81, 42);
        this.AddAccusationMapping(6, 208, -1, 1, 41, 83);
        this.AddAccusationMapping(6, 209, -1, 0, 81, 42);
        this.AddAccusationMapping(6, 209, -1, 1, 41, 83);
        this.AddAccusationMapping(6, 102, -1, 0, 82, 40);
        this.AddAccusationMapping(6, 102, -1, 1, 1, 41);
        this.AddAccusationMapping(6, 210, -1, 0, 40, 0);
        this.AddAccusationMapping(6, 210, -1, 1, 80, 20);
        this.AddAccusationMapping(6, 106, -1, 0, 120, 121);
        this.AddAccusationMapping(6, 106, -1, 1, 122, 103);
        this.AddAccusationMapping(6, 107, -1, 0, 123, 120);
        this.AddAccusationMapping(6, 107, -1, 1, 21, 122);
        this.AddAccusationMapping(6, 105, -1, 0, 30, 30);
        this.AddAccusationMapping(6, 105, -1, 1, 23, 21);
        this.AddAccusationMapping(6, 103, -1, 0, 121, 123);
        this.AddAccusationMapping(6, 103, -1, 1, 122, 103);
        this.AddAccusationMapping(6, 104, -1, 0, 100, 121);
        this.AddAccusationMapping(6, 104, -1, 1, 22, 103);
        this.AddAccusationMapping(6, 109, -1, 0, 140, 121);
        this.AddAccusationMapping(6, 109, -1, 1, 41, 122);
        this.AddAccusationMapping(6, 108, -1, 0, 0, 140);
        this.AddAccusationMapping(6, 108, -1, 1, 23, 143);
        this.AddAccusationMapping(6, 111, -1, 0, 0, 81);
        this.AddAccusationMapping(6, 111, -1, 1, 24, 44);
        this.AddAccusationMapping(6, 112, -1, 0, 2, 0);
        this.AddAccusationMapping(6, 112, -1, 1, 22, 23);
        this.AddAccusationMapping(6, 110, -1, 0, 4, 187);
        this.AddAccusationMapping(6, 110, -1, 1, 5, 188);
        this.AddAccusationMapping(6, 116, -1, 0, 100, 123);
        this.AddAccusationMapping(6, 116, -1, 1, 101, 27);
        this.AddAccusationMapping(6, 117, -1, 0, 120, 121);
        this.AddAccusationMapping(6, 117, -1, 1, 122, 122);
        this.AddAccusationMapping(6, 118, -1, 0, 123, 82);
        this.AddAccusationMapping(6, 118, -1, 1, 122, 122);
        this.AddAccusationMapping(6, 119, -1, 0, 3, 82);
        this.AddAccusationMapping(6, 119, -1, 1, 61, 61);
        this.AddAccusationMapping(6, 122, -1, 0, 2, 0);
        this.AddAccusationMapping(6, 122, -1, 1, 80, 23);
        this.AddAccusationMapping(6, 123, -1, 0, 2, 100);
        this.AddAccusationMapping(6, 123, -1, 1, 23, 20);
        this.AddAccusationMapping(6, 124, -1, 0, 2, 100);
        this.AddAccusationMapping(6, 124, -1, 1, 23, 24);
        this.AddAccusationMapping(6, 125, -1, 0, 200, 100);
        this.AddAccusationMapping(6, 125, -1, 1, 26, 23);
        this.AddAccusationMapping(6, 126, -1, 0, 201, 180);
        this.AddAccusationMapping(6, 126, -1, 1, 181, 27);
        this.AddAccusationMapping(6, 120, -1, 0, 144, 144);
        this.AddAccusationMapping(6, 120, -1, 1, 45, 45);
        this.AddAccusationMapping(6, 121, -1, 0, 104, 104);
        this.AddAccusationMapping(6, 121, -1, 1, 105, 105);
        this.AddAccusationMapping(6, 127, -1, 0, 161, 161);
        this.AddAccusationMapping(6, 127, -1, 1, 143, 142);
        this.AddAccusationMapping(6, 128, -1, 0, 201, 201);
        this.AddAccusationMapping(6, 128, -1, 1, 186, 186);
        this.AddAccusationMapping(1, 20, 1, 1, 25, 101);
        this.AddAccusationMapping(1, 20, 0, 0, 160, 202);
        this.AddAccusationMapping(1, 21, 0, 0, 202, 184);
        this.AddAccusationMapping(1, 21, 1, 1, 101, 186);
        this.AddAccusationMapping(1, 22, 1, 1, 25, 183);
        this.AddAccusationMapping(1, 22, 0, 0, 161, 182);
        this.AddAccusationMapping(1, 23, 1, 1, 25, 183);
        this.AddAccusationMapping(1, 23, 0, 0, 161, 182);
        this.AddAccusationMapping(1, 31, -1, 0, 187, 187);
        this.AddAccusationMapping(1, 31, -1, 1, 188, 188);
        this.AddAccusationMapping(3, 40, -1, 0, 180, 184);
        this.AddAccusationMapping(3, 40, -1, 1, 181, 186);
        this.AddAccusationMapping(3, 41, -1, 0, 180, 184);
        this.AddAccusationMapping(3, 41, -1, 1, 181, 186);
        this.AddAccusationMapping(3, 42, -1, 0, 182, 184);
        this.AddAccusationMapping(3, 42, -1, 1, 184, 186);
        this.AddAccusationMapping(3, 43, -1, 0, 141, 184);
        this.AddAccusationMapping(3, 43, -1, 1, 142, 186);
        this.AddAccusationMapping(3, 44, -1, 0, 184, 180);
        this.AddAccusationMapping(3, 44, -1, 1, 185, 181);
        this.AddAccusationMapping(3, 45, -1, 0, 200, 184);
        this.AddAccusationMapping(3, 45, -1, 1, 26, 186);
        this.AddAccusationMapping(3, 46, -1, 0, 2, 102);
        this.AddAccusationMapping(3, 46, -1, 1, 23, 26);
        this.AddAccusationMapping(3, 47, -1, 0, 0, 3);
        this.AddAccusationMapping(3, 47, -1, 1, 20, 5);
        this.AddAccusationMapping(3, 48, -1, 0, 140, 160);
        this.AddAccusationMapping(3, 48, -1, 1, 143, 181);
        this.AddAccusationMapping(3, 49, -1, 0, 62, 28);
        this.AddAccusationMapping(3, 49, -1, 1, 125, 27);
        this.AddAccusationMapping(3, 50, -1, 0, 42, 124);
        this.AddAccusationMapping(3, 50, -1, 1, 60, 83);
        this.AddAccusationMapping(3, 51, -1, 0, 43, 124);
        this.AddAccusationMapping(3, 51, -1, 1, 44, 61);
        this.AddAccusationMapping(3, 52, -1, 0, 102, 28);
        this.AddAccusationMapping(3, 52, -1, 1, 27, 103);
        this.AddAccusationMapping(3, 53, -1, 0, 43, 124);
        this.AddAccusationMapping(3, 53, -1, 1, 61, 44);
        this.AddAccusationMapping(3, 54, -1, 0, 104, 100);
        this.AddAccusationMapping(3, 54, -1, 1, 105, 101);
        this.AddAccusationMapping(0, 0, -1, 0, 184, 180);
        this.AddAccusationMapping(0, 0, -1, 1, 186, 23);
        this.AddAccusationMapping(0, 1, -1, 0, 29, 184);
        this.AddAccusationMapping(0, 1, -1, 1, 186, 23);
        this.AddAccusationMapping(0, 2, -1, 0, 82, 0);
        this.AddAccusationMapping(0, 2, -1, 1, 143, 80);
        this.AddAccusationMapping(0, 3, -1, 0, 201, 29);
        this.AddAccusationMapping(0, 3, -1, 1, 80, 186);
        this.AddAccusationMapping(0, 4, -1, 0, 184, 201);
        this.AddAccusationMapping(0, 4, -1, 1, 186, 183);
        this.AddAccusationMapping(0, 5, -1, 0, 184, 180);
        this.AddAccusationMapping(0, 5, -1, 1, 186, 23);
        this.AddAccusationMapping(0, 7, -1, 0, 82, 184);
        this.AddAccusationMapping(0, 7, -1, 1, 143, 186);
        this.AddAccusationMapping(0, 8, -1, 0, 29, 201);
        this.AddAccusationMapping(0, 8, -1, 1, 80, 186);
        this.AddAccusationMapping(0, 9, -1, 0, 82, 0);
        this.AddAccusationMapping(0, 9, -1, 1, 143, 80);
        this.AddAccusationMapping(0, 10, -1, 0, 141, 184);
        this.AddAccusationMapping(0, 10, -1, 1, 143, 142);
        this.AddAccusationMapping(0, 11, -1, 0, 184, 180);
        this.AddAccusationMapping(0, 11, -1, 1, 186, 181);
        this.AddAccusationMapping(0, 12, -1, 0, 184, 180);
        this.AddAccusationMapping(0, 12, -1, 1, 186, 181);
        this.AddAccusationMapping(0, 13, -1, 0, 184, 180);
        this.AddAccusationMapping(0, 13, -1, 1, 185, 181);
        this.AddAccusation(0, 0, 0, 0);
        this.AddAccusation(1, 0, 1, 0);
        this.AddAccusation(2, 0, 0, 0);
        this.AddAccusation(3, 0, 0, 0);
        this.AddAccusation(4, 0, 0, 0);
        this.AddAccusation(5, 0, 1, 0);
        this.AddAccusation(20, 1, 1, 0);
        this.AddAccusation(21, 1, 1, 0);
        this.AddAccusation(22, 1, 1, 0);
        this.AddAccusation(23, 1, 1, 0);
        this.AddAccusation(24, 1, 1, 0);
        this.AddAccusation(25, 1, 1, 0);
        this.AddAccusation(26, 1, 1, 0);
        this.AddAccusation(27, 1, 1, 0);
        this.AddAccusation(28, 1, 0, 0);
        this.AddAccusation(29, 1, 0, 0);
        this.AddAccusation(30, 1, 0, 0);
        this.AddAccusation(40, 2, 0, 0);
        this.AddAccusation(41, 2, 1, 0);
        this.AddAccusation(42, 2, 0, 0);
        this.AddAccusation(43, 2, 0, 0);
        this.AddAccusation(44, 2, 1, 0);
        this.AddAccusation(45, 2, 1, 0);
        this.AddAccusation(60, 3, 1, 0);
        this.AddAccusation(61, 3, 1, 0);
        this.AddAccusation(62, 3, 0, 0);
        this.AddAccusation(80, 4, 1, 0);
        this.AddAccusation(81, 4, 0, 0);
        this.AddAccusation(82, 4, 0, 0);
        this.AddAccusation(83, 4, 1, 0);
        this.AddAccusation(100, 5, 0, 0);
        this.AddAccusation(101, 5, 1, 0);
        this.AddAccusation(102, 5, 0, 0);
        this.AddAccusation(103, 5, 1, 0);
        this.AddAccusation(104, 5, 0, 0);
        this.AddAccusation(105, 5, 1, 0);
        this.AddAccusation(120, 6, 0, 0);
        this.AddAccusation(121, 6, 0, 0);
        this.AddAccusation(122, 6, 1, 0);
        this.AddAccusation(123, 6, 0, 0);
        this.AddAccusation(124, 6, 0, 0);
        this.AddAccusation(125, 6, 1, 0);
        this.AddAccusation(140, 7, 0, 0);
        this.AddAccusation(141, 7, 0, 0);
        this.AddAccusation(142, 7, 1, 0);
        this.AddAccusation(143, 7, 1, 0);
        this.AddAccusation(144, 7, 0, 0);
        this.AddAccusation(160, 8, 0, 0);
        this.AddAccusation(161, 8, 0, 0);
        this.AddAccusation(162, 8, 0, 0);
        this.AddAccusation(180, 9, 0, 0);
        this.AddAccusation(181, 9, 1, 0);
        this.AddAccusation(182, 9, 0, 0);
        this.AddAccusation(183, 9, 1, 0);
        this.AddAccusation(184, 9, 0, 0);
        this.AddAccusation(185, 9, 1, 0);
        this.AddAccusation(186, 9, 1, 0);
        this.AddAccusation(187, 9, 0, 0);
        this.AddAccusation(188, 9, 1, 0);
    }
    
    static {
        CrisisAccusationMapping.accList = new LinkedList();
        CrisisAccusationMapping.accMapList = new LinkedList();
    }
    
    class CrisisAccusationMappingElement
    {
        public int pcType;
        public int pcParam;
        public int buggedChr;
        public int chrToSpeak;
        public int accusationID1;
        public int accusationID2;
        
        private final /* synthetic */ void this() {
            this.pcType = -1;
            this.pcParam = -1;
            this.buggedChr = -1;
            this.chrToSpeak = -1;
            this.accusationID1 = -1;
            this.accusationID2 = -1;
        }
        
        CrisisAccusationMappingElement() {
            this.this();
        }
    }
    
    class CrisisAccusation
    {
        public int accusationID;
        public int backstoryCategory;
        public int chrToSpeak;
        public int dialogToSpeak;
        public boolean bSpoken;
        
        private final /* synthetic */ void this() {
            this.accusationID = -1;
            this.backstoryCategory = -1;
            this.chrToSpeak = -1;
            this.dialogToSpeak = -1;
            this.bSpoken = false;
        }
        
        CrisisAccusation() {
            this.this();
        }
    }
}
