function solution(S) {
    // Implement your solution here
    let foundMatch = true;
    while (foundMatch){
        if(S.includes('AA')){
            S = S.replace('AA','');
        }else if(S.includes('BB')){
            S = S.replace('BB','')
        }else if(S.includes('CC')){
            S = S.replace('CC','')
        }else{
            foundMatch = false;
        }
    }
    return S;
}