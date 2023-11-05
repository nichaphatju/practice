function solution(T) {
    let sizeOfA = 0;
    let sizeOfB = 0;
    let AafterB = [];
    let BBeforeA = [];
    if(T.charAt(0) === 'A'){
        sizeOfA +=1;
    }else{
        sizeOfB += 1;
    }
    for(let i=1; i< T.length; i++){
        if(T.charAt(i) === 'A' && T.charAt(i-1) === 'B'){
            AafterB.push(i);
            BBeforeA.push(i-1);
        }
        if(T.charAt(i) === 'A'){
            sizeOfA++;
        }else if(T.charAt(i) === 'B'){
            sizeOfB++;
        }
    }

    if(sizeOfA >= sizeOfB){
        let toRemoveB = 0;
        for(let i=0; i< BBeforeA.length; i++){
            let st = BBeforeA[i];
            while(st >= 0 && T.charAt(st) == 'B'){
                toRemoveB++;
                st--;
            }
            
            
        }
        return toRemoveB;
    }
    return AafterB.length;

}

console.log('Result BAAABAB ' +solution('BAAABAB'));
console.log('Result BBA ' +solution('BBA'));
console.log('Result BBABA ' +solution('BBABA'));
console.log('Result AAABAABB ' +solution('AAABAABB'));
console.log('Result AABBAA ' +solution('AABBAA'));