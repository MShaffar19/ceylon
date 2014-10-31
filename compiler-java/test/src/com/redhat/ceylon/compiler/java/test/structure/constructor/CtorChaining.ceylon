@noanno
class ChainingInit() {
    
}
@noanno
@nomain
class ChainingCtor extends ChainingInit {
    shared new ChainingCtor() extends ChainingInit() {
        
    }
    shared new NonDefault() extends ChainingInit() {
        
    }
}

@noanno
class ChainingCtorInit1() extends ChainingCtor() {

}
//@noanno
//class ChainingCtorInit2() extends ChainingCtor.ChainingCtor() {
//    
//}
//@noanno
//class ChainingCtorInit3() extends ChainingCtor.NonDefault() {
//    
//}

@noanno
@nomain
class ChainingCtorCtor extends ChainingCtor {
    shared new ChainingCtorCtor() extends super.ChainingCtor() {
    }
    new NonDefault() extends super.NonDefault() {
    }
    
}