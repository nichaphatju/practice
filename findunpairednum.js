function solution(A) {
    // Implement your solution here

    let num = 0;
    let occurances = new Map();
    for(let i=0; i< A.length; i++){
        if(occurances.has(A[i])){
            occurances.set(A[i], occurances.get(A[i])+1);
        }else{
            occurances.set(A[i], 1);
        }
    }
    for(let [k,v] of occurances){
        if(v%2 !== 0) return k;
    }
    return num;
}