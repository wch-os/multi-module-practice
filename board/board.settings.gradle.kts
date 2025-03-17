val board = rootDir
    .resolve("board")  // "board" 폴더 기준으로 시작
    .walkTopDown()     // 최상위부터 하위 디렉토리까지 탐색
    .maxDepth(3)       // 탐색 깊이 제한
    .filter(File::isDirectory)  // 디렉토리만 필터링
    .associateBy(File::getName) // 디렉토리 이름을 Key로 하고, File 객체를 Value로 하는 Map 생성


include(
    "board",

    // "board" 모듈의 하위 모듈로 관리
    "board:api",
    "board:application"
)

project(":board").projectDir = board["board"]!!
project(":board:api").projectDir = board["api"]!!
project(":board:application").projectDir = board["application"]!!