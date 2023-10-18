function solution(A) {
    // Implement your solution her
    // Example Input [112, 21, 21, 23]
    let pairCount = 0;
    let mapnum = {};
    for(let i=0; i<A.length ; i++){
        let firstChar = A[i].toString().charAt(0);
        if(mapnum[firstChar]){
            mapnum[firstChar].push(A[i]);
        }else{
            mapnum[firstChar] = [A[i]];
        }
    }
    for(let i=0; i<A.length ; i++){
        let chStr = A[i].toString();
        let lastChar = chStr.charAt(chStr.length-1);
        if(mapnum[lastChar]) pairCount = pairCount + mapnum[lastChar].length;
    }
    return pairCount;
}

var result = solution([112, 21, 21, 23]);
console.log(result);