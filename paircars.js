function solution(A) {
    // Implement your solution her
    let pairCount = 0;
    let eastCar = 0;
    for(let i=0; i<A.length ; i++){
        if(A[i] === 0){
            eastCar++;
        }else{
            pairCount += eastCar;
        }
        if(pairCount > 1000000000){
            return -1;
        }
    }
    return pairCount;
}