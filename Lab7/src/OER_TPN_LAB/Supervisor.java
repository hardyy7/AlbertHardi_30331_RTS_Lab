package OER_TPN_LAB;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;


public class Supervisor {
    public static void main(String[] args){
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor Petri";
        pn.NetworkPort = 1082;

        // <----> PLACES <---->
        DataInteger ps_i1 = new DataInteger();
        ps_i1.SetName("ps_i1");
        pn.PlaceList.add(ps_i1);

        DataInteger ps_1 = new DataInteger();
        ps_1.SetName("ps_1");
        ps_1.SetValue(1);
        pn.PlaceList.add(ps_1);

        DataInteger ps_2 = new DataInteger();
        ps_2.SetName("ps_2");
        ps_2.SetValue(1);
        pn.PlaceList.add(ps_2);

        DataInteger ps_3 = new DataInteger();
        ps_3.SetName("ps_3");
        ps_3.SetValue(1);
        pn.PlaceList.add(ps_3);

        DataInteger ps_i2 = new DataInteger();
        ps_i2.SetName("ps_i2");
        pn.PlaceList.add(ps_i2);

        DataInteger ps_o2 = new DataInteger();
        ps_o2.SetName("ps_o2");
        pn.PlaceList.add(ps_o2);

        DataTransfer ps_o1 = new DataTransfer();
        ps_o1.SetName("ps_o1");
        ps_o1.Value = new TransferOperation("localhost", "1080", "p_i1");
        pn.PlaceList.add(ps_o1);


        // <----> ts_1 <---->
        PetriTransition ts_1 = new PetriTransition(pn);
        ts_1.TransitionName = "ts_1";
        ts_1.InputPlaceName.add("ps_i1");
        ts_1.InputPlaceName.add("ps_1");

        // grd1
        Condition Ts1Ct1 = new Condition(ts_1, "ps_i1", TransitionCondition.NotNull);
        Condition Ts1Ct2 = new Condition(ts_1, "ps_1", TransitionCondition.NotNull);
        Ts1Ct1.SetNextCondition(LogicConnector.AND, Ts1Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = Ts1Ct1;

        grdT11.Activations.add(new Activation(ts_1, "ps_i1", TransitionOperation.AddElement, "ps_1"));
        ts_1.GuardMappingList.add(grdT11);

        ts_1.Delay = 0;
        pn.Transitions.add(ts_1);

        // <----> ts_2 <---->
        PetriTransition ts_2 = new PetriTransition(pn);
        ts_2.TransitionName = "ts_2";
        ts_2.InputPlaceName.add("ps_1");
        ts_2.InputPlaceName.add("ps_2");
        ts_2.InputPlaceName.add("ps_3");

        // grd1
        Condition Ts2Ct1 = new Condition(ts_2, "ps_1", TransitionCondition.NotNull);
        Condition Ts2Ct2 = new Condition(ts_2, "ps_2", TransitionCondition.NotNull);
        Condition Ts2Ct3 = new Condition(ts_2, "ps_1", TransitionCondition.NotEqual, "ps_2");

        Ts2Ct2.SetNextCondition(LogicConnector.AND, Ts2Ct3);
        Ts2Ct1.SetNextCondition(LogicConnector.AND, Ts2Ct2);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = Ts2Ct1;

        grdT21.Activations.add(new Activation(ts_2, "ps_1", TransitionOperation.Copy, "ps_o1"));
        ts_1.GuardMappingList.add(grdT21);

        ts_2.Delay = 0;
        pn.Transitions.add(ts_2);

        // grd2
        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = Ts2Ct1;

        grdT21.Activations.add(new Activation(ts_2, "ps_3", TransitionOperation.Copy, "ps_1"));
        ts_1.GuardMappingList.add(grdT22);

        // <----> ts_3 <---->
        PetriTransition ts_3 = new PetriTransition(pn);
        ts_3.TransitionName = "ts_2";
        ts_3.InputPlaceName.add("ps_i2");

        // grd1
        Condition Ts3Ct1 = new Condition(ts_3, "ps_i2", TransitionCondition.NotNull);

        GuardMapping grdT31 = new GuardMapping();
        grdT31.condition = Ts3Ct1;

        grdT31.Activations.add(new Activation(ts_3, "ps_i2", TransitionOperation.Copy, "ps_2"));
        grdT31.Activations.add(new Activation(ts_3, "ps_i2", TransitionOperation.Copy, "ps_o2"));
        ts_3.GuardMappingList.add(grdT31);

        ts_3.Delay = 0;
        pn.Transitions.add(ts_3);
        
        // same as in the Robot.java class
        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 3000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
