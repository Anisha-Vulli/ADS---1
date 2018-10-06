int allcount = 0;
        for (int i = 0; i < stucount && open > 0 && vacant >0; i++) {
            if (stuarray[i].cat.equals("Open")) {
                addseats(stuarray[i]);
                open--;
                allcount++;
                vacant--;   
            }
        }

        for (int j = 0; j < stucount && vacant > 0; j++) {
            if (stuarray[j].cat.equals("BC") && bc > 0) {
                addseats(stuarray[j]);
                allcount++;
                bc--;
                vacant--;
            }

            if (stuarray[j].cat.equals("SC") && sc > 0) {
                addseats(stuarray[j]);
                allcount++;
                sc--;
                vacant--;
            }

            if (stuarray[j].cat.equals("ST") && st > 0) {
                addseats(stuarray[j]);
                allcount++;
                st--;
                vacant--;
            }
        }