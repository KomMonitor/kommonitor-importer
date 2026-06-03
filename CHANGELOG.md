# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Changed

- Aff git-cliff config ([3c079d6](https://github.com/KomMonitor/kommonitor-importer/commit/3c079d6094112fe1f34c9e8ec28b3ffe8872db09))
- [maven-release-plugin] prepare for next development iteration ([984f0cd](https://github.com/KomMonitor/kommonitor-importer/commit/984f0cd8f4e81443495498c46277e5be7102840c))
- Merge branch 'develop' into feature/test ([e3b49f8](https://github.com/KomMonitor/kommonitor-importer/commit/e3b49f8029b24d7fbf7c8cabb2d26ac3c2f47682))
- Adjust POM ([95e1c56](https://github.com/KomMonitor/kommonitor-importer/commit/95e1c56466dd8426a053bcb0cfcfe343c9520753))
- [maven-release-plugin] Update CHANGELOG.md ([3cf2b39](https://github.com/KomMonitor/kommonitor-importer/commit/3cf2b39a4c71dff05c5dc5312bd8fd5ee6076217))
- Change pom ([54644fb](https://github.com/KomMonitor/kommonitor-importer/commit/54644fb2e9b94e632dc172a4991d89a26f540b78))
- [maven-release-plugin] Update CHANGELOG.md ([6d94644](https://github.com/KomMonitor/kommonitor-importer/commit/6d94644707eb7a9a856a93cd3091c63491c101bf))
- [maven-release-plugin] Update CHANGELOG.md ([b3d3647](https://github.com/KomMonitor/kommonitor-importer/commit/b3d3647699d9f4855967313005d696b01bb3e8d8))
- [maven-release-plugin] Update CHANGELOG.md ([a39b774](https://github.com/KomMonitor/kommonitor-importer/commit/a39b77472b23f6b783c78e5b7d8b34b91de2941e))

### Removed

- Remove things ([05f90b9](https://github.com/KomMonitor/kommonitor-importer/commit/05f90b9ea9c7b1169fe3b3c818fe43b7ea120d08))

## [4.2.1]
>  5 May 2026

### Changed

- Merge commit '52f33d9452255564d6c3b41b8e7f9dbf433f32fa' ([dbd0b27](https://github.com/KomMonitor/kommonitor-importer/commit/dbd0b27d619b8d8bff290d3482c25fdf4b2628c8))
- Implement global optional proxy with optional Auth. adjusted usage of REST Template and httphelper in other classes - tested with tinyproxy - http retriever and OGC API retrieval yet to test ([7cd96c8](https://github.com/KomMonitor/kommonitor-importer/commit/7cd96c8b1ada3ac0b43d5508bb50992da4b9dd48))
- [maven-release-plugin] prepare for next development iteration ([c276150](https://github.com/KomMonitor/kommonitor-importer/commit/c276150b97c8e6b2c3208b94e8fd9289b691c9a1))
- Merge branch 'master' into develop ([38ee432](https://github.com/KomMonitor/kommonitor-importer/commit/38ee432beceffcf6a754172763282542587677d9))
- Provide custom entrypoint.sh to fix extra certs issues ([3c92100](https://github.com/KomMonitor/kommonitor-importer/commit/3c92100f74cda11237e96b45a8017fbaefd916b3))
- Pin Tricy action to safe version ([1ee365d](https://github.com/KomMonitor/kommonitor-importer/commit/1ee365d39cca0c3614f58fd37bcbbf4d354b8f30))
- Merge branch 'develop' into feature/http-proxy ([7ce0520](https://github.com/KomMonitor/kommonitor-importer/commit/7ce05203bbb3f3de947290c1cdf9543645d6c4a9))
- Adjust NimbusJwtDecoder setup and include optional issuer-uri check ([36e92b3](https://github.com/KomMonitor/kommonitor-importer/commit/36e92b3234d98ae1e8d651faa5d4e8fcad24cbaa))
- [maven-release-plugin] Update CHANGELOG.md ([c1aa5da](https://github.com/KomMonitor/kommonitor-importer/commit/c1aa5da34e11313510243478c1a4509cad3524f8))
- [maven-release-plugin] prepare release 4.2.1 ([0fc43ea](https://github.com/KomMonitor/kommonitor-importer/commit/0fc43ead5b56babb31ea3c52998b001ee5b0ae53))

### Fixed

- Fix internal data management requests preserving bearer token authentication - still allow external requests tunneled through configurable proxy ([059bd66](https://github.com/KomMonitor/kommonitor-importer/commit/059bd66a4ce9ac0e22c3d9c985f85c2789586321))
- Fix global proxy setup and refactor code. now all cases (with/without proxy - with/without proxy auth) should work and no NullPointer on missing proxy parameters; logs may will admins about mismatching proxy settings ([8d7f44c](https://github.com/KomMonitor/kommonitor-importer/commit/8d7f44c4a67e62b078b1f2ad1e592c90dacb7b30))

## [4.2.0]
>  6 Nov 2025

### Added

- Add aggregation type to models ([b313283](https://github.com/KomMonitor/kommonitor-importer/commit/b313283ae302721ff566f1921f302a0fb5d8d3c8))

### Changed

- Merge commit 'af9bd9d5359560e643ce26b9b413c0f8e565fe96' ([62595f9](https://github.com/KomMonitor/kommonitor-importer/commit/62595f99980fdd6672ac9d198fc13b02fa939003))
- [maven-release-plugin] prepare for next development iteration ([236f65e](https://github.com/KomMonitor/kommonitor-importer/commit/236f65eec5c88a3d7987ba1e816f32cb291d2511))
- Generate models for new aggregation parameter ([07f32d9](https://github.com/KomMonitor/kommonitor-importer/commit/07f32d9ccd2576faa103ab2e4d39e0dbe381d62b))
- Regenerate API classes for introducing required POST body constraint ([1ef3e3d](https://github.com/KomMonitor/kommonitor-importer/commit/1ef3e3dc26cd7102edbad8f9d7c039f46dac8b6a))
- Refactor controller classes ([38b6c0d](https://github.com/KomMonitor/kommonitor-importer/commit/38b6c0d59c017c6716877cdd0acbea64c2c302b1))
- Refactor DataSourceRetrieverRepository ([be426e5](https://github.com/KomMonitor/kommonitor-importer/commit/be426e5e94f60ae1827b39fedc454ab809bcdfae))
- Replace deprecated mock annotation ([7b2a86b](https://github.com/KomMonitor/kommonitor-importer/commit/7b2a86b83c037609f8cea0563e1658f7a68172a9))
- Introduce aggregation for higher spatial units ([1f89cf5](https://github.com/KomMonitor/kommonitor-importer/commit/1f89cf5f551cc4625d5c0453411b1585e492a45e))
- Implement count aggregation ([cf081ad](https://github.com/KomMonitor/kommonitor-importer/commit/cf081ad657ffcee15a576359be0696faecf73175))
- Implement aggregation unit tests ([09c66bf](https://github.com/KomMonitor/kommonitor-importer/commit/09c66bfc7b0c169ac41d3a021231ebfec37ef25a))
- Take into account results for aggregations in response and monitor ([460c434](https://github.com/KomMonitor/kommonitor-importer/commit/460c43444772e1463fa82e042d906b84a306ce16))
- Include successfully aggregated features in response ([56335a7](https://github.com/KomMonitor/kommonitor-importer/commit/56335a7636a7577e806b7f7f4ca02dab9dce0151))
- Adjust docker test setup ([b0bc09b](https://github.com/KomMonitor/kommonitor-importer/commit/b0bc09b42175a170ffb31862b2241041f86b3823))
- Refactor unit tests and add tests for aggregation count ([3d439d7](https://github.com/KomMonitor/kommonitor-importer/commit/3d439d75d1853b6725990dcff59a1be6c74b39b4))
- Implement further agregation functions and add tests ([b19e2af](https://github.com/KomMonitor/kommonitor-importer/commit/b19e2af397881d59369deae73949dc73dbd5e076))
- Increase minor version ([3f8d5c7](https://github.com/KomMonitor/kommonitor-importer/commit/3f8d5c72d010c905c7c4e361fd618bd52b287712))
- Set default log level to DEBUG ([1582c81](https://github.com/KomMonitor/kommonitor-importer/commit/1582c81a3bf31e627492c6be7e217e44d2f55de6))
- [maven-release-plugin] Update CHANGELOG.md ([993614e](https://github.com/KomMonitor/kommonitor-importer/commit/993614ec4fa7d9f6b05ec03ec684d2e6e71102c0))
- [maven-release-plugin] prepare release 4.2.0-beta.1 ([26bb4ec](https://github.com/KomMonitor/kommonitor-importer/commit/26bb4ec356040e1666d9ab922ab1116c529b43c7))
- Merge commit '26bb4ec356040e1666d9ab922ab1116c529b43c7' ([c56b5df](https://github.com/KomMonitor/kommonitor-importer/commit/c56b5df95d77b7790ed712d234ff9f6462ffeb34))
- [maven-release-plugin] prepare for next development iteration ([c34cd98](https://github.com/KomMonitor/kommonitor-importer/commit/c34cd98a2faee506c854c17c72132606eb9a1fba))
- Update base Docker run image ([00e3796](https://github.com/KomMonitor/kommonitor-importer/commit/00e379681fc2216ecf62e3d701c80464398cf3f4))
- [maven-release-plugin] Update CHANGELOG.md ([a7aba5f](https://github.com/KomMonitor/kommonitor-importer/commit/a7aba5fb13b26b2a04f494dc92cb2a13dd16e2c5))
- [maven-release-plugin] prepare release 4.2.0 ([52f33d9](https://github.com/KomMonitor/kommonitor-importer/commit/52f33d9452255564d6c3b41b8e7f9dbf433f32fa))

### Fixed

- Fix tests ([200a3c6](https://github.com/KomMonitor/kommonitor-importer/commit/200a3c670c25e1daad8a70a2de5e08f458d7dd27))
- Fix count aggregation ([c24693f](https://github.com/KomMonitor/kommonitor-importer/commit/c24693f23dfd782bd003be2d682e316bc2d4222c))
- Fix higher spatial unit aggregation ([f8b4d32](https://github.com/KomMonitor/kommonitor-importer/commit/f8b4d32f94595914c65c6303b6919e3a589b5536))
- Fix empty value list for aggregation ([2e70c12](https://github.com/KomMonitor/kommonitor-importer/commit/2e70c12940b34f8890b9a8c828285290ee0f233c))
- Fix reading features in a byte array ([c6a35d5](https://github.com/KomMonitor/kommonitor-importer/commit/c6a35d5b6a65f1d22ff37905a8a3f37e0a6e39f5))

## [4.1.1]
>  2 Sep 2025

### Changed

- [maven-release-plugin] prepare for next development iteration ([68ff50b](https://github.com/KomMonitor/kommonitor-importer/commit/68ff50b1ef35fa3e28448025e92c495f77aea39e))
- Update dependencies ([622f24b](https://github.com/KomMonitor/kommonitor-importer/commit/622f24bcce022a75dc537aa857013814341863d5))
- Update GeoTools library and fix package import ([807d047](https://github.com/KomMonitor/kommonitor-importer/commit/807d04793a73f38eaf0e5ce3ac3b61de22001855))
- Merge branch 'master' into develop ([112cd03](https://github.com/KomMonitor/kommonitor-importer/commit/112cd03450baa4aaf26c5e393713e04ac88630a1))
- Update models class ([f4f3715](https://github.com/KomMonitor/kommonitor-importer/commit/f4f3715d62ef35e600a6f8deeb9b18fd93f84a90))
- [maven-release-plugin] Update CHANGELOG.md ([aa53a71](https://github.com/KomMonitor/kommonitor-importer/commit/aa53a71e9a4572537bb2c008424b284ed4e9c5ae))
- [maven-release-plugin] prepare release 4.1.1-beta.1 ([e14b95c](https://github.com/KomMonitor/kommonitor-importer/commit/e14b95ccb339401eed0946953b35dafbda5f4df6))
- [maven-release-plugin] prepare for next development iteration ([172df4b](https://github.com/KomMonitor/kommonitor-importer/commit/172df4be78b1d6d0c78d39765181cdf37fd6a8ce))
- Update Docker setup ([f486ceb](https://github.com/KomMonitor/kommonitor-importer/commit/f486ceb5d302b59f0cb1a71ee94d0cb9a96ee29a))
- Update dependencies ([d348d92](https://github.com/KomMonitor/kommonitor-importer/commit/d348d9256a14b4719b8c5c636353499845e91892))
- Regenerate API classes ([97fd485](https://github.com/KomMonitor/kommonitor-importer/commit/97fd48511cb8ab732b9f93d641af2951e40d9ed7))
- Regenerate model classes ([da681a5](https://github.com/KomMonitor/kommonitor-importer/commit/da681a5fd250920a432fab2905116c6254edd1c3))
- Update API client classes ([6241bf2](https://github.com/KomMonitor/kommonitor-importer/commit/6241bf2e9142034cd66c8b2df9fec1f4d691c9db))
- [maven-release-plugin] Update CHANGELOG.md ([19de4e4](https://github.com/KomMonitor/kommonitor-importer/commit/19de4e4df4ffb2a2a5466cdd25ae3c317901d53e))
- [maven-release-plugin] prepare release 4.1.1-beta.2 ([cba5189](https://github.com/KomMonitor/kommonitor-importer/commit/cba518968af6fb58020ca9168adb5b2263d71cbd))
- [maven-release-plugin] prepare for next development iteration ([7b5fd8f](https://github.com/KomMonitor/kommonitor-importer/commit/7b5fd8f7040f2dbe58367226fd87b6b2734e8460))
- Change model class generation config and regenerate models ([9538269](https://github.com/KomMonitor/kommonitor-importer/commit/9538269c5d6bbd75952a043d1aedf599471b840c))
- [maven-release-plugin] Update CHANGELOG.md ([f5b0202](https://github.com/KomMonitor/kommonitor-importer/commit/f5b02026f5dccdec2471b85a23f87c25fb8f44b2))
- [maven-release-plugin] prepare release 4.1.1 ([af9bd9d](https://github.com/KomMonitor/kommonitor-importer/commit/af9bd9d5359560e643ce26b9b413c0f8e565fe96))

## [4.1.0]
> 28 May 2025

### Changed

- [maven-release-plugin] prepare for next development iteration ([ed62758](https://github.com/KomMonitor/kommonitor-importer/commit/ed62758eb998ce4e8f2f490ea6bbd06cf462b35e))
- Merge branch 'master' into develop ([de3377d](https://github.com/KomMonitor/kommonitor-importer/commit/de3377dc32e06b731266996f4e3be400bba295fc))
- Regenerate model classes ([15a7d1d](https://github.com/KomMonitor/kommonitor-importer/commit/15a7d1d429cec1b7388e384c6a51990bc6a6d07f))
- Regenerate API classes ([ae0e816](https://github.com/KomMonitor/kommonitor-importer/commit/ae0e8166d4717cfd068ca2a4b9daa250faba7d53))
- [maven-release-plugin] Update CHANGELOG.md ([e7b359c](https://github.com/KomMonitor/kommonitor-importer/commit/e7b359c9f2f96b75a5000951769ebe261965a8cd))
- [maven-release-plugin] prepare release 4.1.0-beta.1 ([be62501](https://github.com/KomMonitor/kommonitor-importer/commit/be625010fbe0a0e63a6e71f7162c975bc1999c39))
- [maven-release-plugin] prepare for next development iteration ([132d030](https://github.com/KomMonitor/kommonitor-importer/commit/132d030bcc07d8a129b0ec1be9d738528e2d6252))
- [maven-release-plugin] Update CHANGELOG.md ([7638aea](https://github.com/KomMonitor/kommonitor-importer/commit/7638aea90ae97a93cbe941f6e2fd2b8ec60d1f12))
- [maven-release-plugin] prepare release 4.1.0 ([72d0001](https://github.com/KomMonitor/kommonitor-importer/commit/72d0001007513db42c334715f996066e60f70266))

## [3.2.5]
> 18 Dec 2024

### Changed

- Update models ([42b5020](https://github.com/KomMonitor/kommonitor-importer/commit/42b50203d330e936cff8bae09252dba784291580))
- Raise Data Management API version for dev Docker setup ([8a319bd](https://github.com/KomMonitor/kommonitor-importer/commit/8a319bd98e75afd626d8cfc0a186a678ef23160b))
- [maven-release-plugin] Update CHANGELOG.md ([d91fbd0](https://github.com/KomMonitor/kommonitor-importer/commit/d91fbd0d867f2dcaffa098daf52db3c6e512b3e7))
- [maven-release-plugin] prepare release 3.2.5 ([0b2da62](https://github.com/KomMonitor/kommonitor-importer/commit/0b2da624afa53064384690b086b056b36bc27189))
- [maven-release-plugin] prepare for next development iteration ([ed2f5f4](https://github.com/KomMonitor/kommonitor-importer/commit/ed2f5f44a91046ec247d10b2b06626c5f2600b33))
- [maven-release-plugin] Update CHANGELOG.md ([e802a3d](https://github.com/KomMonitor/kommonitor-importer/commit/e802a3d3a23047a758499bd33fd5ed5f35a1079a))
- [maven-release-plugin] prepare release 3.2.5 ([077c125](https://github.com/KomMonitor/kommonitor-importer/commit/077c1256b5e1c71659b72521221dc952d95a8438))

### Fixed

- Fix IT compilation ([3c08ebf](https://github.com/KomMonitor/kommonitor-importer/commit/3c08ebf082da790e850e11613128fb721581b622))

## [4.0.0]
> 11 Dec 2024

### Changed

- [maven-release-plugin] prepare for next development iteration ([7a47b51](https://github.com/KomMonitor/kommonitor-importer/commit/7a47b51ed2c0b631989b373c62727f0add6904ff))
- Pin Eclipse Temurin image version ([49ca4c6](https://github.com/KomMonitor/kommonitor-importer/commit/49ca4c601d828dfde3a8d8a2541a9b5e57f91825))
- Generate latest models ([ad80c28](https://github.com/KomMonitor/kommonitor-importer/commit/ad80c28aafc979b6bcbb17e4cd5948908e5c8776))
- Generate latest API client classes ([466bc71](https://github.com/KomMonitor/kommonitor-importer/commit/466bc7175d6f84985ac4fd837b3bf02a6a70c23a))
- Regenerate latest API models ([a2fa4e1](https://github.com/KomMonitor/kommonitor-importer/commit/a2fa4e18f1abebbb66e356e635f24fcb3e6df807))
- Merge branch 'project/kme-va-2023' into develop ([9bc8a0f](https://github.com/KomMonitor/kommonitor-importer/commit/9bc8a0fa7b94c15d7aa9ee975ab3a94ee809795c))
- Genereate latest models ([d7def55](https://github.com/KomMonitor/kommonitor-importer/commit/d7def5580d369299a0f11e2dadfc7f112b54dd43))
- Seta beta version ([61ea497](https://github.com/KomMonitor/kommonitor-importer/commit/61ea497d21360b0cff3dabce780e2cd731818855))
- [maven-release-plugin] Update CHANGELOG.md ([da8368d](https://github.com/KomMonitor/kommonitor-importer/commit/da8368ddff6393a12202215bbe0a585afbddadf5))
- [maven-release-plugin] prepare release 4.0.0-beta.1 ([7214f26](https://github.com/KomMonitor/kommonitor-importer/commit/7214f26300374125400a86f3d1dc2b099dad7554))
- [maven-release-plugin] prepare for next development iteration ([e1d68b0](https://github.com/KomMonitor/kommonitor-importer/commit/e1d68b08513437b079292633409f337982fe89c9))
- Raise cache actions version ([8bb380a](https://github.com/KomMonitor/kommonitor-importer/commit/8bb380ae67f9dc9b6e50cf9e28b784d8c31c0d0c))

### Fixed

- Fix erronous regionalReferenceValueType API model ([5fe5de3](https://github.com/KomMonitor/kommonitor-importer/commit/5fe5de3fcdd77afb97870f39a02b5911e090224f))

### Removed

- Remove deprecated properties from indicator test entity ([4b3ed7c](https://github.com/KomMonitor/kommonitor-importer/commit/4b3ed7c18652714a32ef8224759687cdf70adafa))

## [3.2.4]
>  3 Apr 2024

### Added

- Add support for ID property as Feature object member ([a4c5f1b](https://github.com/KomMonitor/kommonitor-importer/commit/a4c5f1bd3bccfba38e192cbe190b13e2587f6a85))

### Changed

- [maven-release-plugin] prepare for next development iteration ([9875908](https://github.com/KomMonitor/kommonitor-importer/commit/9875908c82ddd32db29fd7ac4c63e97dfb0bafc8))
- [maven-release-plugin] Update CHANGELOG.md ([cd4f483](https://github.com/KomMonitor/kommonitor-importer/commit/cd4f48321c6ec7abdd19d341be4ac6dea7bcda96))
- [maven-release-plugin] prepare release 3.2.4 ([cd50adf](https://github.com/KomMonitor/kommonitor-importer/commit/cd50adf2a9b37bd35a1620e0feb8b1d5155fe0b2))

## [3.2.3]
> 30 Jan 2024

### Added

- Add throws Exception to API method signatures ([903c077](https://github.com/KomMonitor/kommonitor-importer/commit/903c077f717e40a767e4a818ef20692a8a010ca2))

### Changed

- [maven-release-plugin] prepare for next development iteration ([b9ff17f](https://github.com/KomMonitor/kommonitor-importer/commit/b9ff17f6d68c50e67c2eda299b7ae2c95a433484))
- Update model classes according the latest spec ([e7ef8dd](https://github.com/KomMonitor/kommonitor-importer/commit/e7ef8dd20379919c05d8e5f22eec9553015e4e5b))
- Update API client classes according the latest Open API spec ([4e8dbeb](https://github.com/KomMonitor/kommonitor-importer/commit/4e8dbebc56b30b761f1da89ad1fdc51fafb0841f))
- Update doc files ([8c5e95d](https://github.com/KomMonitor/kommonitor-importer/commit/8c5e95d359f1a9b6bb8838843db55c897d790158))
- Small config updates ([35fe659](https://github.com/KomMonitor/kommonitor-importer/commit/35fe65910ebde9e46a651c97c6be6beb08dbcb7b))
- [maven-release-plugin] Update CHANGELOG.md ([d18dc1a](https://github.com/KomMonitor/kommonitor-importer/commit/d18dc1a13734bbdf35f1b034703e9ad410130dfe))
- [maven-release-plugin] prepare release 3.2.3 ([71ceb8d](https://github.com/KomMonitor/kommonitor-importer/commit/71ceb8d3f132f41fe306b860b9f2dcea39c94eac))

## [3.2.2]
> 28 Nov 2023

### Added

- Add CORS configuration support ([116aeb4](https://github.com/KomMonitor/kommonitor-importer/commit/116aeb4e15854002feeb72c96fdc9276ae2477a3))
- Add encoding method parameter to ConverterDefinition ([1b558c2](https://github.com/KomMonitor/kommonitor-importer/commit/1b558c20df21236dd65c9b8db54309f888193642))

### Changed

- [maven-release-plugin] prepare for next development iteration ([ff47161](https://github.com/KomMonitor/kommonitor-importer/commit/ff4716147fc38dbfff2f3b7d886b0000bfa196fa))
- Merge branch 'develop' into feature/encoding ([0579698](https://github.com/KomMonitor/kommonitor-importer/commit/05796988585f8d264799acf062daf553200b9d13))
- Refine encoding detection according the encoding method ([32052d6](https://github.com/KomMonitor/kommonitor-importer/commit/32052d6fe2ed2ab76ace5aa9f7c8c4fc7691cc8c))
- Refine encoding detection according the encoding detection methodw ([93ce0a6](https://github.com/KomMonitor/kommonitor-importer/commit/93ce0a67bbb397fd8b8532476a947c64c147ab8c))
- Apply code refinements ([0e78004](https://github.com/KomMonitor/kommonitor-importer/commit/0e7800433ab987166b7cc4534114507f1e78fd8f))
- Refine temp file deletion ([11c60a8](https://github.com/KomMonitor/kommonitor-importer/commit/11c60a86f96dc25cd2868484fa1bbf983328eeef))
- [maven-release-plugin] Update CHANGELOG.md ([907745c](https://github.com/KomMonitor/kommonitor-importer/commit/907745c03377ca8f5b90fa07c172fe7e3421ba61))
- Revert geocoder URL initializing ([5969718](https://github.com/KomMonitor/kommonitor-importer/commit/5969718e4e5878b564aad2b069f0a39ea0a921b5))
- [maven-release-plugin] Update CHANGELOG.md ([3063432](https://github.com/KomMonitor/kommonitor-importer/commit/3063432a2aa8a9d45a82d895ef7cc50a93c1b31c))
- [maven-release-plugin] prepare release 3.2.2 ([41f7ba8](https://github.com/KomMonitor/kommonitor-importer/commit/41f7ba85b572862d0312117cecd6704b22c38d10))

## [3.2.1]
> 20 Nov 2023

### Added

- Add manual postConstruct call to test of components ([305c256](https://github.com/KomMonitor/kommonitor-importer/commit/305c2567e0c7f5d1bb33df4dc77038e4b1a03421))

### Changed

- Merge branch 'master' into develop ([5ba6171](https://github.com/KomMonitor/kommonitor-importer/commit/5ba617140fa6cb1e55d27a243ad87f6f88e3b9bd))
- Enhance geometry parsing failure handling ([d0e2163](https://github.com/KomMonitor/kommonitor-importer/commit/d0e2163472e7ae05bd1814269ad970328934ba3d))
- [maven-release-plugin] Update CHANGELOG.md ([d4dfee5](https://github.com/KomMonitor/kommonitor-importer/commit/d4dfee597b9b759f17530bb8b33a2341de75d525))
- [maven-release-plugin] Update CHANGELOG.md ([9b07911](https://github.com/KomMonitor/kommonitor-importer/commit/9b0791150284bb01cf5bdf3fe8db87e5f98d5031))
- [maven-release-plugin] prepare release 3.2.1 ([7cf905a](https://github.com/KomMonitor/kommonitor-importer/commit/7cf905a6ec966ea46ce0d00598ca7067cdcee45a))

### Fixed

- Fix http proxy not being configured ([23ad395](https://github.com/KomMonitor/kommonitor-importer/commit/23ad395d4c34b1904bf6778b68af050dbf1b8684))

## [3.2.0]
> 15 Nov 2023

### Added

- Add exact cropping of result features to referenceGeometry ([0e6c30a](https://github.com/KomMonitor/kommonitor-importer/commit/0e6c30a2720bd87664ee13c770e4223f1b52db2a))
- Add new Converter for OGC-API Features ([655d7d0](https://github.com/KomMonitor/kommonitor-importer/commit/655d7d08c2ac68615c0801386894c9df2e10397a))
- Support custom filter for ogcapi-features + improve error logging ([da70d7f](https://github.com/KomMonitor/kommonitor-importer/commit/da70d7f6f49fc3c743089d49215979fc1035eeef))
- Add proxy support for OA - Features Retriever ([08718d6](https://github.com/KomMonitor/kommonitor-importer/commit/08718d60168dd96da84f4bd934afcdc3f76b05b1))
- Add tests for APIFeaturesConverter ([18f1d8e](https://github.com/KomMonitor/kommonitor-importer/commit/18f1d8ee153b3e41a88a2f5dace808109aca46e4))
- Add missing test file ([776a48e](https://github.com/KomMonitor/kommonitor-importer/commit/776a48ea93c5278461d50f1ad4a3579f6a6864ed))

### Changed

- [maven-release-plugin] prepare for next development iteration ([4eb6b70](https://github.com/KomMonitor/kommonitor-importer/commit/4eb6b7067aab12fa8a864470179555eae24c421b))
- Regenerate models + align implementations to models ([9035061](https://github.com/KomMonitor/kommonitor-importer/commit/9035061ed622484807ebe1cd8e5077ee13dc7828))
- Implement DatasourceType `OGC API - Features` ([04bf610](https://github.com/KomMonitor/kommonitor-importer/commit/04bf61042571f321c34e105e905616c3e971c0b7))
- Merge remote-tracking branch 'origin/develop' into feature/oa_features ([335e7af](https://github.com/KomMonitor/kommonitor-importer/commit/335e7af23f804daa1bdd68c5e861d0e525050c22))
- Refactor HttpHelper to use caching ([fe0e96f](https://github.com/KomMonitor/kommonitor-importer/commit/fe0e96ff1cc0de53693d47be8de949c5789c6ed4))
- Improve error messagen on empty features ([59a9f29](https://github.com/KomMonitor/kommonitor-importer/commit/59a9f2912067b49e0ab5c972d4e7629bab543890))
- Merge remote-tracking branch 'origin/master' into feature/oa_features ([9d9aeb2](https://github.com/KomMonitor/kommonitor-importer/commit/9d9aeb2084208365aaf85e49c7faacd3323010c7))
- Improve datasourceconfig documentation for ogc api features retriever ([d845002](https://github.com/KomMonitor/kommonitor-importer/commit/d845002083372a3aae8bf0c8c8ea2dbe7af4ecb6))
- Document CRS parameter for OGC API - Features Converter ([c5df4d0](https://github.com/KomMonitor/kommonitor-importer/commit/c5df4d04a9aed018ef1a2e36a444ae3b854b54a6))
- Merge pull request #25 from KomMonitor/feature/oa_features ([b11a204](https://github.com/KomMonitor/kommonitor-importer/commit/b11a20458d092a5de1f4dca8980e2f56b8aa493e))
- Implement test for APIFeaturesRetriever ([9ecfbcf](https://github.com/KomMonitor/kommonitor-importer/commit/9ecfbcf8385467ab6b813c0a2888cae7b90f52dd))
- Improve CRS parameter handling for APIFeaturesConverter ([fe34288](https://github.com/KomMonitor/kommonitor-importer/commit/fe3428875b2ae1cc4011c9d03fc8657daba6a1c6))
- Raise deps ([a50d89f](https://github.com/KomMonitor/kommonitor-importer/commit/a50d89f6a40e18af3291f3688eb7481a628831b2))
- [maven-release-plugin] Update CHANGELOG.md ([b2dbf34](https://github.com/KomMonitor/kommonitor-importer/commit/b2dbf34263029b4d9b9a823bfef5c563567d1934))
- [maven-release-plugin] prepare release 3.2.0 ([a762081](https://github.com/KomMonitor/kommonitor-importer/commit/a762081bb73d4c3998c74174747fd34f8d44be2c))
- [maven-release-plugin] prepare for next development iteration ([10a260e](https://github.com/KomMonitor/kommonitor-importer/commit/10a260eef8bd1e26385f1fc303e4aa3801670c1d))

### Fixed

- Fix mandatory flag for datasourceParameters ([7f284ff](https://github.com/KomMonitor/kommonitor-importer/commit/7f284ff71ac74dafcb94d105413c9c12baa05596))
- Fix invalid bbox parsing when locale is not US ([19cfbec](https://github.com/KomMonitor/kommonitor-importer/commit/19cfbec0b74ed9fac7d64b0f0b442ea0e366819a))

### Removed

- Remove simplification of geometries ([87a9ce1](https://github.com/KomMonitor/kommonitor-importer/commit/87a9ce180d874a1e7b07415e30b86f5d6bfbc4d8))

## [3.1.1]
>  7 Nov 2023

### Added

- Add charset detection to Shapefile converter ([8eec858](https://github.com/KomMonitor/kommonitor-importer/commit/8eec8586a81f59cb78a32fed8e12973d0884b6c1))
- Add default encoding property to converters ([ae9ddc6](https://github.com/KomMonitor/kommonitor-importer/commit/ae9ddc6df48065d48d37ffec87fb7703145a8b7c))
- Add support for different encoding to GeoJSON converter ([8d2cf30](https://github.com/KomMonitor/kommonitor-importer/commit/8d2cf3036d8ad9055f1f7487211d8aa5a0090bfd))
- Add additional supported encodings ([74a723f](https://github.com/KomMonitor/kommonitor-importer/commit/74a723f6dd2fdfc0c324d492ac054e8ebe5a7c19))
- Add proxy support for HTTP based datasource retriever ([203ac3b](https://github.com/KomMonitor/kommonitor-importer/commit/203ac3bc4a446c80acf92cc4ee8b0e05b01da248))

### Changed

- [maven-release-plugin] prepare for next development iteration ([3509428](https://github.com/KomMonitor/kommonitor-importer/commit/3509428374ffd43d74fc4620313b90b70b6aa5e1))
- Improve Exception handling ([26ddf1d](https://github.com/KomMonitor/kommonitor-importer/commit/26ddf1d29319d870ec1e9670c6bc51d4ffd4f327))
- Use newer version of tika parser ([fced6ac](https://github.com/KomMonitor/kommonitor-importer/commit/fced6acafd2395061e6ad7f8b5a1a1836c7d0ec0))
- Refactor GeopackageConverter ([2fafff0](https://github.com/KomMonitor/kommonitor-importer/commit/2fafff009e5e6512a402f3529c498cfea1f091a8))
- [maven-release-plugin] Update CHANGELOG.md ([2f0403a](https://github.com/KomMonitor/kommonitor-importer/commit/2f0403a42bd8b43ec54679a4351f342429f7f8db))
- [maven-release-plugin] prepare release 3.1.1 ([68b667a](https://github.com/KomMonitor/kommonitor-importer/commit/68b667a4ab39b985b4b17c36cc7525c90b1d7849))

### Fixed

- Fix tests ([02e199c](https://github.com/KomMonitor/kommonitor-importer/commit/02e199c86a8a4ac57a3d7a85d858ddc05aa0108e))
- Fix imports ([77494cc](https://github.com/KomMonitor/kommonitor-importer/commit/77494cc532d3df2fd1ea62e644d388c0d3cb1c1f))

## [3.1.0]
> 19 Sep 2023

### Added

- Add Geopackage layer parameter ([60b8a83](https://github.com/KomMonitor/kommonitor-importer/commit/60b8a8386af6a9a58d2956cf58a94cec3fd707ad))

### Changed

- [maven-release-plugin] prepare for next development iteration ([6a51941](https://github.com/KomMonitor/kommonitor-importer/commit/6a51941572f88bd586a3f8d28e02186b1d13357c))
- Create converter for Geopackage datasets ([82664ff](https://github.com/KomMonitor/kommonitor-importer/commit/82664ff89dd232b405c007ee509e72f953256c95))
- Improve feature decoding implementation ([06add73](https://github.com/KomMonitor/kommonitor-importer/commit/06add73df119053285ba6eddb5dd2486855cae8e))
- Move indicator value grouping to AbstractConverter ([001fa25](https://github.com/KomMonitor/kommonitor-importer/commit/001fa25f77a7f5635d24035a1cb13be03e57680d))
- Refine GeoJsonConverter and ShapeConverter ([c08a9a7](https://github.com/KomMonitor/kommonitor-importer/commit/c08a9a71c2602ca87428e78fa0eb97b49b53534f))
- Finalize GeopackageConverter ([f96509c](https://github.com/KomMonitor/kommonitor-importer/commit/f96509ce5658a048e036d327f22c2877a0208413))
- Enhance testing for GeoJSON and Geopackage files ([d86fae4](https://github.com/KomMonitor/kommonitor-importer/commit/d86fae4cd4088611fa0ce13eb90b3667520cd93c))
- Rename test file ([b9d8db5](https://github.com/KomMonitor/kommonitor-importer/commit/b9d8db5a75947b32a4f75b76ab2eabfb5bb99b09))
- [maven-release-plugin] Update CHANGELOG.md ([39a0faf](https://github.com/KomMonitor/kommonitor-importer/commit/39a0faf2fe2be9e8b263e4df286314a18334a28d))
- [maven-release-plugin] prepare release 3.1.0 ([f2febf3](https://github.com/KomMonitor/kommonitor-importer/commit/f2febf329dc6ea194fe9944328c3ce83c8656848))

## [3.0.0]
> 18 Aug 2023

### Added

- Add missing entities ([3978444](https://github.com/KomMonitor/kommonitor-importer/commit/397844425d95522e7868e02f1a0fcf488070b245))
- Add DataManagement API to dockre compose for testing purpose ([ddc681f](https://github.com/KomMonitor/kommonitor-importer/commit/ddc681f616bba7e94768ca6d26fa370444270df6))
- Add new API client documentation ([2095c44](https://github.com/KomMonitor/kommonitor-importer/commit/2095c442d63056116666828e5bd6fb2eb8815496))
- Add openapi-generator dir to gitignore ([7554f5a](https://github.com/KomMonitor/kommonitor-importer/commit/7554f5a861b1179f5d690d635f6bb8197a050962))

### Changed

- [maven-release-plugin] prepare for next development iteration ([f936785](https://github.com/KomMonitor/kommonitor-importer/commit/f9367851985991ab5570808b96373fc8448869e3))
- Migrate dependencies to Spring Boot 3 and Springdoc-openapi ([78bef9e](https://github.com/KomMonitor/kommonitor-importer/commit/78bef9ebd5966299c390b7633feb4080aa6348e0))
- Regenerate model classes with openapi-generator using swagger 3 annotations ([ebdc37f](https://github.com/KomMonitor/kommonitor-importer/commit/ebdc37ff8248904089e9c356af410f7820d3720d))
- Migrate API to springdoc ([cbb9cd9](https://github.com/KomMonitor/kommonitor-importer/commit/cbb9cd9d2bf678b6afa265c2a138ecf21f83f02b))
- Migrate to spring security for with OAuth2 support ([229983c](https://github.com/KomMonitor/kommonitor-importer/commit/229983c4b6f9314090ae8b56aee68a72fea79111))
- Regenerate API classes using OpenAPI Generator ([902dd95](https://github.com/KomMonitor/kommonitor-importer/commit/902dd953595b3a05fb1f0a619ccaa2da78643eae))
- Switch swagger-ignore to openapi-generator-ignore ([7c6df46](https://github.com/KomMonitor/kommonitor-importer/commit/7c6df464fb728a1df733a2c6404caf8e7b65ed97))
- Clean up POMs ([bbf22e4](https://github.com/KomMonitor/kommonitor-importer/commit/bbf22e4d7719a2657d60fcc971878d34ef3cadd9))
- Refine API authentication ([383ab76](https://github.com/KomMonitor/kommonitor-importer/commit/383ab76b4dbdec05b9a5e019261e28bd5f0dc964))
- Use plain spring security authentication for http client REST calls ([69bcc4b](https://github.com/KomMonitor/kommonitor-importer/commit/69bcc4b8280e7a96f1f3c6943c7cc067828e00eb))
- Tidy up config params ([b810ab8](https://github.com/KomMonitor/kommonitor-importer/commit/b810ab85c2836fbc2859f577eac338816f092c70))
- Mark old api client classes as legacy ([14f35a0](https://github.com/KomMonitor/kommonitor-importer/commit/14f35a0819c83bc2de7208730d8de923aac39c14))
- Regenerate api client classes using openapi-generator ([1aa0c6a](https://github.com/KomMonitor/kommonitor-importer/commit/1aa0c6a436f63c0f73abd4513c5a0ec31bb8883e))
- Regenerate API classes ([ef858b3](https://github.com/KomMonitor/kommonitor-importer/commit/ef858b340ee9f217f62b08d2b38b19143973da23))
- Use CMD instead of ENTRYPOINT ([612c134](https://github.com/KomMonitor/kommonitor-importer/commit/612c134183c5fe7feb1c5fb37be175b1d0b0635f))
- Prepare next major release ([dd1d76f](https://github.com/KomMonitor/kommonitor-importer/commit/dd1d76f215621cc9bbd752d55de851937dec0b62))
- [maven-release-plugin] Update CHANGELOG.md ([2d0a7e1](https://github.com/KomMonitor/kommonitor-importer/commit/2d0a7e1a010717abad41dbf4faf8ac3aaaf6b01b))
- [maven-release-plugin] prepare release 3.0.0 ([72852df](https://github.com/KomMonitor/kommonitor-importer/commit/72852df00730c6218a884445d5c9099758b2b531))

### Fixed

- Fix response types and imports ([fb0f7b3](https://github.com/KomMonitor/kommonitor-importer/commit/fb0f7b3f2530ceb7bfb3520bc508a7aa1f2457b3))
- Fix URL paths ([266ca4e](https://github.com/KomMonitor/kommonitor-importer/commit/266ca4e8d42ef6db8c36a961424d0f431298c506))

### Removed

- Remove unimplemented integration tests ([3bd88c8](https://github.com/KomMonitor/kommonitor-importer/commit/3bd88c8dc7d5c508c3cd46dae9e2c74f58049c9d))

## [2.0.7]
>  2 Aug 2023

### Changed

- [maven-release-plugin] prepare for next development iteration ([763003d](https://github.com/KomMonitor/kommonitor-importer/commit/763003d78c45767495380d2bdf20ab8c67a73446))
- Use JDK17 base image for running app ([b940ae8](https://github.com/KomMonitor/kommonitor-importer/commit/b940ae8429bf62c510e4eb614841d273c5687950))
- [maven-release-plugin] Update CHANGELOG.md ([2ff9c1d](https://github.com/KomMonitor/kommonitor-importer/commit/2ff9c1d315cf5a529c662262627480f4850edffc))
- [maven-release-plugin] prepare release 2.0.7 ([fce9a5d](https://github.com/KomMonitor/kommonitor-importer/commit/fce9a5d6ea09fd09ac566701449212b1abf3b590))

## [2.0.6]
>  2 Aug 2023

### Added

- Add CVE scan action ([94f282b](https://github.com/KomMonitor/kommonitor-importer/commit/94f282bd746b344ab563e21c8ffe276a7be24d32))

### Changed

- [maven-release-plugin] prepare for next development iteration ([6ebb747](https://github.com/KomMonitor/kommonitor-importer/commit/6ebb7474329298f8991e9a46b813ef141165d97c))
- Switch to JDK 17 as target compile version and raise deprecated dependencies ([5463b55](https://github.com/KomMonitor/kommonitor-importer/commit/5463b5566272c736936708663d68b966429d1e85))
- Use JDK17 base Docker image ([15101c3](https://github.com/KomMonitor/kommonitor-importer/commit/15101c3b2facb079180c74471e8dcda568e4f325))
- [maven-release-plugin] Update CHANGELOG.md ([278b5d9](https://github.com/KomMonitor/kommonitor-importer/commit/278b5d9b43932cb9d06a0abbe3271f8f07c591fa))
- [maven-release-plugin] prepare release 2.0.6 ([75c7bf0](https://github.com/KomMonitor/kommonitor-importer/commit/75c7bf0685604e491897a451ebadca3c3b5be6f0))

### Fixed

- Fix CVE scan action ([1802d1d](https://github.com/KomMonitor/kommonitor-importer/commit/1802d1d6a0e80c46226ecdfa650336615d4b07a4))
- Fix git-changelog plugin version ([f722d54](https://github.com/KomMonitor/kommonitor-importer/commit/f722d5420d7c98797bcfc88f763959b714095e8f))

### Removed

- Remove push to develop event for build action ([9f13e1e](https://github.com/KomMonitor/kommonitor-importer/commit/9f13e1e400a56e38b45b144ee1569a120293befb))

## [2.0.5]
> 26 Jun 2023

### Changed

- [maven-release-plugin] prepare for next development iteration ([a956d79](https://github.com/KomMonitor/kommonitor-importer/commit/a956d79ab51230cddb002059b1688126af093085))
- For excel/CSV import ensure that empty header cells do not break import process ([62f3492](https://github.com/KomMonitor/kommonitor-importer/commit/62f3492be94a4d3c68b6759b24bc53b37a4ac160))
- [maven-release-plugin] Update CHANGELOG.md ([a4907e2](https://github.com/KomMonitor/kommonitor-importer/commit/a4907e2fe0abdc3039bd1f96b784da45c21f291c))
- [maven-release-plugin] prepare release 2.0.5 ([ba1fb0a](https://github.com/KomMonitor/kommonitor-importer/commit/ba1fb0a706a8ad6f3e1c0abdb5c66d1c1f6fffc5))

## [2.0.4]
> 29 Mar 2023

### Added

- Add proxy support for geocoder requests ([ed6412c](https://github.com/KomMonitor/kommonitor-importer/commit/ed6412ca61d9da1611dcc68b2317eea6b3428542))

### Changed

- [maven-release-plugin] prepare for next development iteration ([c1ad8cb](https://github.com/KomMonitor/kommonitor-importer/commit/c1ad8cb175d099ad34a5bb64d1f5f08e0df2b90c))
- [maven-release-plugin] Update CHANGELOG.md ([1e61425](https://github.com/KomMonitor/kommonitor-importer/commit/1e61425041438f221c424efdd66b04143ee60119))
- [maven-release-plugin] Update CHANGELOG.md ([2d71423](https://github.com/KomMonitor/kommonitor-importer/commit/2d714235698c8b67edbdb7afc94d170c56bfeee6))
- [maven-release-plugin] prepare release 2.0.4 ([61c592a](https://github.com/KomMonitor/kommonitor-importer/commit/61c592a7c02ebafbac18bd2d8070d50a602546ee))

## [2.0.3]
>  3 Mar 2023

### Added

- Add Docker Compose setup for quickstart ([a7050ce](https://github.com/KomMonitor/kommonitor-importer/commit/a7050ce303774ca65bf53ad04ceda4f9b0e2f6ea))

### Changed

- [maven-release-plugin] prepare for next development iteration ([1ef8775](https://github.com/KomMonitor/kommonitor-importer/commit/1ef87757859c34b801630e38939a51bb2c79bb7f))
- Make host for Swagger-UI configurable ([89f722e](https://github.com/KomMonitor/kommonitor-importer/commit/89f722efba5d3df681a09b892015313c967fa8a2))
- [maven-release-plugin] Update CHANGELOG.md ([946a80d](https://github.com/KomMonitor/kommonitor-importer/commit/946a80dfa3ab6528b7b4bac8e035e855d813c872))
- [maven-release-plugin] prepare release 2.0.3 ([a155998](https://github.com/KomMonitor/kommonitor-importer/commit/a155998980f4bceebde6d681de4d838ae883d250))

### Removed

- Remove deprecated Docker Compose ([38ffc42](https://github.com/KomMonitor/kommonitor-importer/commit/38ffc42b2aa13ee6c6270c93ea596e14f109aaed))

## [2.0.2]
>  7 Nov 2022

### Changed

- [maven-release-plugin] prepare for next development iteration ([06cfbad](https://github.com/KomMonitor/kommonitor-importer/commit/06cfbadc2ff81ef016b903d9ce46d2023cfb0927))
- Bump keycloak-adapter version ([8d97014](https://github.com/KomMonitor/kommonitor-importer/commit/8d97014e6b86a8a1ac66c4e94615c1e96af2c142))
- [maven-release-plugin] Update CHANGELOG.md ([c42f040](https://github.com/KomMonitor/kommonitor-importer/commit/c42f040ff72778f022462e5ffa687ce9dc8f3262))
- [maven-release-plugin] prepare release 2.0.2 ([6b2efa2](https://github.com/KomMonitor/kommonitor-importer/commit/6b2efa2a18f965ab40ee163644f50947f727203d))

## [2.0.1]
>  7 Nov 2022

### Added

- Add another property for geocoding purposes to data model ([3a041ce](https://github.com/KomMonitor/kommonitor-importer/commit/3a041ce3e04ea72a4933022e567af0ed1bf35c43))

### Changed

- [maven-release-plugin] prepare for next development iteration ([33b2092](https://github.com/KomMonitor/kommonitor-importer/commit/33b209204ea0c6ad72abb8c9a391222de3f23e1c))
- Implement a simple Shape converter using ZIP folder with flat structure ([a1265c0](https://github.com/KomMonitor/kommonitor-importer/commit/a1265c02f374d1452f46be4f9bd3dc773985ed16))
- Improve geocoding imports by considering new geocoderank property of geocoder proxy component ([04889b0](https://github.com/KomMonitor/kommonitor-importer/commit/04889b0497c425cd927b767bf438ada2143d6c1f))
- Change type of property "geocodedesc" added in previous commit [3a041ce] to String. ([0be5396](https://github.com/KomMonitor/kommonitor-importer/commit/0be5396958d4303baab525c3f294ebccd55d60a4))
- Bump keycloak-adapter version ([46edfc4](https://github.com/KomMonitor/kommonitor-importer/commit/46edfc4fba6638b912dafa0f3d5cfa980a4f3cb5))
- [maven-release-plugin] Update CHANGELOG.md ([b62e572](https://github.com/KomMonitor/kommonitor-importer/commit/b62e5728dacc78a9b89622ced303c882c9bfef41))
- [maven-release-plugin] Update CHANGELOG.md ([083aae8](https://github.com/KomMonitor/kommonitor-importer/commit/083aae8cef69100be7d848bfed72917bce7008cf))
- [maven-release-plugin] prepare release 2.0.1 ([59a41c4](https://github.com/KomMonitor/kommonitor-importer/commit/59a41c41825f5d12a83fd0a9f8e2908291c1e6dd))

## [2.0.0]
> 24 Jul 2022

### Added

- Add URL to geocoder service preparing CSV and Excel based geocoding of addresses to points ([4cc8a6f](https://github.com/KomMonitor/kommonitor-importer/commit/4cc8a6f2ddfc0ca4458ea438f53f4790fcaf3fad))
- Add apache POI dependency in app module to prevent runtime classNotFoundDef error ([76a5f9f](https://github.com/KomMonitor/kommonitor-importer/commit/76a5f9f5e7efe4d68283d48f1356043bb6aceaf6))
- Add a new table converter to geocode points from streetHousnumber column and city column ([c3324ae](https://github.com/KomMonitor/kommonitor-importer/commit/c3324aed83fcc572066d75955e130d21ecc48225))

### Changed

- [maven-release-plugin] prepare for next development iteration ([8fd7ff3](https://github.com/KomMonitor/kommonitor-importer/commit/8fd7ff386cfc05175e7bdebc7e42e96f862d911f))
- Allow any authenticated role to use importer ([2906813](https://github.com/KomMonitor/kommonitor-importer/commit/29068132cca0856b9a3576015af16f299c2ba0bd))
- First draft for implementing CSV based addressToPointGeoresource, both from query string and from structured query ([9f31390](https://github.com/KomMonitor/kommonitor-importer/commit/9f31390699b1092a7e49b630ea632485fae83579))
- Refactor code; introduce an abstract table converter ([1c02858](https://github.com/KomMonitor/kommonitor-importer/commit/1c0285844cdba5eef839ee9895830585360f861c))
- Allow excel for table based data import; renaming former CSV specific converters to more generic table-based converters ([23a6ce1](https://github.com/KomMonitor/kommonitor-importer/commit/23a6ce1c9b1338598257032845f4310cec93d0b8))
- Refactor CSV separator code ([9a166ab](https://github.com/KomMonitor/kommonitor-importer/commit/9a166ab2968aa0f87687b5343d4134707e7f2a43))
- Filter geocoder results only to those entries with housenumber (remove type=building, as type might have other meaningful values representing houses) ([33848e1](https://github.com/KomMonitor/kommonitor-importer/commit/33848e11e4378d472f0d7493ddd0e00f152bf963))
- Rename and relabel converters to german expressions ([403d875](https://github.com/KomMonitor/kommonitor-importer/commit/403d8754ef8aebd1a1e9e986309e8235ced8dab0))
- Commit code that actually should enhance importer to convert incoming text files to UTF-8 encoding. However that broke dependency management. must be resolved step by step ([4f7e361](https://github.com/KomMonitor/kommonitor-importer/commit/4f7e36124e1566848fac6da06547286e13c88c35))
- Exclude some dependenciees from tika parsers as this caused conflicts with geotools, now file encoding detection seems to work for text files ([4e7378f](https://github.com/KomMonitor/kommonitor-importer/commit/4e7378f59dd4e5f5170d5e36138b72923d531453))
- Implement batch geocoder queries ([bba161c](https://github.com/KomMonitor/kommonitor-importer/commit/bba161ce3f935258685dd38852aa5f80fc89705a))
- Improve/fix CSV file parsing by bumping geotools to v 26.3 --> no replacement within source file needed anymore ([bf22ecc](https://github.com/KomMonitor/kommonitor-importer/commit/bf22eccdd5425237d9dacbf60d612bdbe017b8f1))
- When querying photon geocoder we should use whitespace to separate each information instead of comma. that vastly improves geocoding ([e8356f3](https://github.com/KomMonitor/kommonitor-importer/commit/e8356f3dfc1908449671b0a833bb76dc7e6bf104))
- Make sure that indicator values can be properly parsed as float, and replace any comma by dot ([c13dbd0](https://github.com/KomMonitor/kommonitor-importer/commit/c13dbd02ada3ebf1d06bd49f2af40bc2d710e665))
- When converting excel to CSV then remove any carriage return and line feeds from the cell values to ensure that they are one-liner ([efc8d6b](https://github.com/KomMonitor/kommonitor-importer/commit/efc8d6bfdc10067ee658f6768023717838b6e70c))
- Delete sysout for test purposes ([70a1d20](https://github.com/KomMonitor/kommonitor-importer/commit/70a1d20a708d672997ce9c3113ec6835c03471a4))
- Replace CSV parsing library, remove getools CSV data store and use openCSV instead to get rid of multiuple parsing issues ([2556022](https://github.com/KomMonitor/kommonitor-importer/commit/255602258b8d8db88fdebe3b266e909a190ceb6a))
- Sort converters and datasource retrievers on api request ([1ce98d9](https://github.com/KomMonitor/kommonitor-importer/commit/1ce98d95832e2eb1735ae4b3ed859ef7229d7861))
- Improve null or empty value decoding of timeseries values. Map empty String, "null" or "undefined" to FLOAT.NAN and consequently as timeseries null value ([694ce9c](https://github.com/KomMonitor/kommonitor-importer/commit/694ce9c7b6d83afa7facbb06da6afc7bf89fb99e))
- Merge branch 'master' of https://github.com/KomMonitor/kommonitor-importer ([89ca1ff](https://github.com/KomMonitor/kommonitor-importer/commit/89ca1ff7198db8d13d9e383c7d2f651ad21827f8))
- [maven-release-plugin] Update CHANGELOG.md ([5383594](https://github.com/KomMonitor/kommonitor-importer/commit/5383594e6b125f7b68180b3d17648632b98e1be5))
- [maven-release-plugin] prepare release 2.0.0-beta ([3205334](https://github.com/KomMonitor/kommonitor-importer/commit/3205334001c09bce62013ea3b4a9dfa383b7ee1b))
- [maven-release-plugin] prepare for next development iteration ([46c5e3b](https://github.com/KomMonitor/kommonitor-importer/commit/46c5e3b9527021d6bf3744efcc8321887f08115c))
- Temporarily ignore test for release v2 ([e9b0263](https://github.com/KomMonitor/kommonitor-importer/commit/e9b02638b80d9d6ce0148e3f7ddac51ea892a6a6))
- [maven-release-plugin] Update CHANGELOG.md ([4674f0f](https://github.com/KomMonitor/kommonitor-importer/commit/4674f0fbc285bad2304763f0e50cc850d7e5e315))
- [maven-release-plugin] prepare release 2.0.0 ([46d273b](https://github.com/KomMonitor/kommonitor-importer/commit/46d273bd3b06c100027eb73be8f6fad280c928ca))

### Fixed

- Fix separator replacement for CSV converter ([2475e4f](https://github.com/KomMonitor/kommonitor-importer/commit/2475e4ff99ca188fd117b454907975aeba49f9d2))
- Fix space character encoding in query string based CSV to point resource converter ([3340b3c](https://github.com/KomMonitor/kommonitor-importer/commit/3340b3c79e679c43dc20dc26f6b30a17427bfe14))
- Fix geocoder query parameter evaluation to null of empty optional parameters in structured CSV address to point comverter ([9514ea6](https://github.com/KomMonitor/kommonitor-importer/commit/9514ea63ee0d4759a98e1786140bf5a23b8ca6f2))
- Fix test conditions ([1b4a041](https://github.com/KomMonitor/kommonitor-importer/commit/1b4a041baf88fc169397f4cc8b74f10e799f3a1c))
- Fix some bugs related to separator parameter ([f41c71a](https://github.com/KomMonitor/kommonitor-importer/commit/f41c71aa90ba0dfcf96ee092b531afa29abd9b25))
- Fix maven build cannot find symbol errors due to Optional.isEmpty() method usage -> now use isPresent() method instead ([af688c4](https://github.com/KomMonitor/kommonitor-importer/commit/af688c492565ce282e477cec9c34cf9110caccab))
- Fix writing of CSV file content to temp file by removing byte order mark id present. that lead to the fact that first column property could not be parsed correctly ([38da3a6](https://github.com/KomMonitor/kommonitor-importer/commit/38da3a6bd4eafa78580f7c035412e9062259141f))
- Fix maven building problem ([f489e12](https://github.com/KomMonitor/kommonitor-importer/commit/f489e129555f644164ce4258490d53823f92f9d2))
- Fix excel parsing error and improve geocoder response filter process. Return error when more than one street was geocoded for a feature ([6e96349](https://github.com/KomMonitor/kommonitor-importer/commit/6e9634906d473265c59fd81b70d5620ae931eb09))
- Fix tests ([48443e0](https://github.com/KomMonitor/kommonitor-importer/commit/48443e0065b1f3e60beef34d3f460f76d0c3dc64))
- Fix UTF-8 conversion of incoming csv files ([46b2e23](https://github.com/KomMonitor/kommonitor-importer/commit/46b2e239e49d5c925478993e35c65bacdf388d47))
- Fix geocoder query strings if postcode has no value ([716c955](https://github.com/KomMonitor/kommonitor-importer/commit/716c955725e5f93bbc8f42b6791f660da45d3eda))
- Fix a problem where UTF8 encoded files were treated as empty File ([83f6f27](https://github.com/KomMonitor/kommonitor-importer/commit/83f6f279f1bed8ae31b54d4687ea8d95c7a068e7))
- Fix naming of latitude longitude columns for CSV import - previous naming caused syntax errors in client because space and minus sign may cause problems within HTML id fields ([5554db4](https://github.com/KomMonitor/kommonitor-importer/commit/5554db40a30671626c82e53882af0c2f6f5dc477))
- Fix code snippet ([dbc7fb8](https://github.com/KomMonitor/kommonitor-importer/commit/dbc7fb8f0033d5dbc9a140ce90aa6a72dd918ab7))

### Removed

- Remove test code ([b316f07](https://github.com/KomMonitor/kommonitor-importer/commit/b316f078c286407aa6e8f6ab5e130f7c55386e8b))
- Remove any empty CSV rows (containing only null values) from parsed dataset ([a850a31](https://github.com/KomMonitor/kommonitor-importer/commit/a850a319674c3c772853df7f42d1997d04a6ee9a))
- Remove ( and ) character from column names as they also cause syntax error in client ([82994d4](https://github.com/KomMonitor/kommonitor-importer/commit/82994d423d01fcd563f9f5e25140f92324929362))

## [1.2.2]
>  7 Feb 2022

### Changed

- [maven-release-plugin] prepare for next development iteration ([e97a0d9](https://github.com/KomMonitor/kommonitor-importer/commit/e97a0d90e9bf92d59021df498f3e79d8824d2c4d))
- Bump log4j-api from 2.16.0 to 2.17.0 ([bcdb309](https://github.com/KomMonitor/kommonitor-importer/commit/bcdb3096499c9f352e90ce24258f3791aaa71a92))
- Merge pull request #21 from KomMonitor/dependabot/maven/org.apache.logging.log4j-log4j-api-2.17.0 ([3dc5dfe](https://github.com/KomMonitor/kommonitor-importer/commit/3dc5dfe21f7c4011bffaf59d0fd9786d49142a8f))
- Bomp log4j version to 2.17.0 ([ea94436](https://github.com/KomMonitor/kommonitor-importer/commit/ea94436f7577749d0a36c5fda1f736da273a3ee9))
- Bump log4j to 2.17.1 ([975022d](https://github.com/KomMonitor/kommonitor-importer/commit/975022d3f0d508e20af57f86ebf8f3828d70860b))
- [maven-release-plugin] Update CHANGELOG.md ([aac7f1b](https://github.com/KomMonitor/kommonitor-importer/commit/aac7f1b29fb01cc5b343ef116ba57e2808a6955c))
- [maven-release-plugin] prepare release 1.2.2 ([e9c64ba](https://github.com/KomMonitor/kommonitor-importer/commit/e9c64ba3a4bdcc4175179bceb26c1323daa5de3e))

## [1.2.1]
> 17 Dec 2021

### Changed

- [maven-release-plugin] prepare for next development iteration ([eecc113](https://github.com/KomMonitor/kommonitor-importer/commit/eecc1130ca2013640872f21ded6bb28a2c1b4a3d))
- Override log4j version to fix critical security issue (although log4j is actually not used) ([28fb70e](https://github.com/KomMonitor/kommonitor-importer/commit/28fb70e111244459aa8533cbf58396f5246f00e3))
- Increase log4j version to 2.16. ([78a341a](https://github.com/KomMonitor/kommonitor-importer/commit/78a341abcc8641c7f9c3f909c7b76a88f001f105))
- Bump spring boot version and adjust code ([b7e7533](https://github.com/KomMonitor/kommonitor-importer/commit/b7e7533d6dd85dc068a699ea7868dee352d82265))
- [maven-release-plugin] Update CHANGELOG.md ([5852ec2](https://github.com/KomMonitor/kommonitor-importer/commit/5852ec276ee27067942541b90d0e025c828fb912))
- [maven-release-plugin] prepare release 1.2.1 ([ceec549](https://github.com/KomMonitor/kommonitor-importer/commit/ceec5497158b50ba0811b9f49011df707f7aa6fd))

## [1.2.0]
>  7 Sep 2021

### Added

- Added CHANGELOGS from submodules to git ignore as we only want to keep the main changelog ([2175c07](https://github.com/KomMonitor/kommonitor-importer/commit/2175c07891de762be320c9b0951142fc7913764d))

### Changed

- [maven-release-plugin] prepare for next development iteration ([b199219](https://github.com/KomMonitor/kommonitor-importer/commit/b1992197868a946775d36e618abd5fe2da09b296))
- Allow spatial units and georesources to be updated partially ([94429a7](https://github.com/KomMonitor/kommonitor-importer/commit/94429a7d69419efc8fae673d868806907bf66fc8))
- [maven-release-plugin] Update CHANGELOG.md ([efb8f74](https://github.com/KomMonitor/kommonitor-importer/commit/efb8f74dbe5e79605e17b0fefae57ce9c5be59f7))
- [maven-release-plugin] prepare release 1.2.0 ([097a4d7](https://github.com/KomMonitor/kommonitor-importer/commit/097a4d7eef2fe36c5cfef6ae6fa4d6d96b7ab9b6))

### Fixed

- Fix parameter submission of isPartialUpdate parameter ([ad2f0fc](https://github.com/KomMonitor/kommonitor-importer/commit/ad2f0fc0f866b49eea34f9913892b031e65010b2))

## [1.0.0]
> 12 May 2021

### Added

- Add initial datamanagement api client module ([8f2acc4](https://github.com/KomMonitor/kommonitor-importer/commit/8f2acc481ddea045466b696e0539e439dfbac5b3))
- Add tests for ConvertersAPIController methods ([1edc20b](https://github.com/KomMonitor/kommonitor-importer/commit/1edc20b3d148785afdf72c3b3c2d8a420872b155))
- Add datasource retriever ([0c8d603](https://github.com/KomMonitor/kommonitor-importer/commit/0c8d603e4773dbe2d0ae317475056026fd80dea3))
- Add a datasource retriever for inline payload ([b888723](https://github.com/KomMonitor/kommonitor-importer/commit/b8887232ea1cc50a5e0979743a509d092277a6cc))
- Add test for datasource type API ([f28d33f](https://github.com/KomMonitor/kommonitor-importer/commit/f28d33f83391f77f2879013044e11627980e6873))
- Add sequence diagrams ([94d6455](https://github.com/KomMonitor/kommonitor-importer/commit/94d6455fe8a408760ff1ebc91728028fcda9f548))
- Add helper classes for HTTP requests ([de66358](https://github.com/KomMonitor/kommonitor-importer/commit/de663582b938ef276650516ff7422d974315c839))
- Add ConverterException ([ae71dff](https://github.com/KomMonitor/kommonitor-importer/commit/ae71dff54c36b95b261b532241555e448f3c498a))
- Add abstract handler for import requests ([9cc87b8](https://github.com/KomMonitor/kommonitor-importer/commit/9cc87b8e84607652510a673ae21b1c8650e9207d))
- Add GeoTools dependencies ([937c236](https://github.com/KomMonitor/kommonitor-importer/commit/937c2366726fabb2653dde469f0e9d13ea4abe1f))
- Add handler for import request exceptions ([c292362](https://github.com/KomMonitor/kommonitor-importer/commit/c292362e678c165a5b24253e3e320a4c6fa2f13d))
- Add encoder ([a2868b2](https://github.com/KomMonitor/kommonitor-importer/commit/a2868b2e7a666a0bf8a49faf0bf6ddb91e4b1d0c))
- Add handler for Georesource imports ([0635d96](https://github.com/KomMonitor/kommonitor-importer/commit/0635d965e0d25c48dde4a463779bfc4697b29bfc))
- Add tests for GeoresourceApiController ([a7d0093](https://github.com/KomMonitor/kommonitor-importer/commit/a7d0093b69b339281e225939fa1bf1e5d5e6fd31))
- Add gt-geojson dependency ([c92a495](https://github.com/KomMonitor/kommonitor-importer/commit/c92a495668aa99e0845a4c614e91ace99eb2ca34))
- Add test for JSON encoding of Spatialresources ([1dc33e7](https://github.com/KomMonitor/kommonitor-importer/commit/1dc33e74cea75916f073bd9a28fc7a8d99fff2fb))
- Add decoder for SimpleFeatures ([4983604](https://github.com/KomMonitor/kommonitor-importer/commit/4983604c5407aba18d89821ef1f48d2b11d052d6))
- Add converter for WFS 1.x sources ([5222f65](https://github.com/KomMonitor/kommonitor-importer/commit/5222f65fac1132440601c321e7fb59d862bc8206))
- Add exception handling for not found resources ([530204f](https://github.com/KomMonitor/kommonitor-importer/commit/530204fde21e7f51c8940ee00f3959381dab906a))
- Add feature decoding tests ([60a18c0](https://github.com/KomMonitor/kommonitor-importer/commit/60a18c06f1a3c622c72b24558bea41c74fc9d387))
- Add retriever for HTTP based datasources ([cf14cf8](https://github.com/KomMonitor/kommonitor-importer/commit/cf14cf82307a80eb2fc312185a3a3d60a9834801))
- Add converter definition validation and unit test ([35e601b](https://github.com/KomMonitor/kommonitor-importer/commit/35e601b006b9816bd99351221e4beb87cfeb9ba5))
- Add tests for SpatialResource converting ([8bd43d3](https://github.com/KomMonitor/kommonitor-importer/commit/8bd43d30250fb2742e5d4df021d04b96e5aeeec8))
- Add encoder for Indicators ([e2f7d24](https://github.com/KomMonitor/kommonitor-importer/commit/e2f7d2463a0d4ef439cce9c1e5688b45dce7c1b4))
- Add instantiation constraints ([b384d7a](https://github.com/KomMonitor/kommonitor-importer/commit/b384d7ae49633e02f9202a6eb4fd0b80d402401d))
- Add decoding of SimpleFeatures to Indicators ([b190717](https://github.com/KomMonitor/kommonitor-importer/commit/b1907178debfa594fb0e06058df91ec6e6974d9b))
- Add Indictaor converting from WFS datasources ([e3ae379](https://github.com/KomMonitor/kommonitor-importer/commit/e3ae37953ebaa77e9eb9d51fc3a88e7765a7883a))
- Add test for importIndicator endpoint ([f5b6ae3](https://github.com/KomMonitor/kommonitor-importer/commit/f5b6ae32d0079ceb2c33692a3ee0d75a99f02df5))
- Add tests for spatialUnitImport endpoint ([1dcaf61](https://github.com/KomMonitor/kommonitor-importer/commit/1dcaf61b0e90a629c6088422103608173a68cda6))
- Add reprojection of feature geometries to WGS 84 CRS ([3b90c46](https://github.com/KomMonitor/kommonitor-importer/commit/3b90c46dc7df8f180827970661c14872620256d6))
- Add CRS parameter handling for WFS converting ([5c99ebe](https://github.com/KomMonitor/kommonitor-importer/commit/5c99ebe2cbc8706a4ffcdd1077585939936c1ead))
- Add constructor injection ([1575392](https://github.com/KomMonitor/kommonitor-importer/commit/1575392057c4a2b01b09baba813d509469face90))
- Add code generation skip for *Controller classes ([9aa1394](https://github.com/KomMonitor/kommonitor-importer/commit/9aa139471add9abe310084c672c0544a198c91b4))
- Add tests for georesource update endpoints ([5837937](https://github.com/KomMonitor/kommonitor-importer/commit/5837937b6377ff126a73a923291885cff511064d))
- Add tests for spatial unit update API endpoints ([7b6fdc7](https://github.com/KomMonitor/kommonitor-importer/commit/7b6fdc79c1f3e4d94022452fa07ec007c9250a8e))
- Add tests for update indicator API endpoint ([a3264ef](https://github.com/KomMonitor/kommonitor-importer/commit/a3264ef9754fbbd55450c0e327eb50bcfc585ccc))
- Add  API client tests for update endpoints ([b2a7f50](https://github.com/KomMonitor/kommonitor-importer/commit/b2a7f50b319ae47c847c87cf51e94ccaac5c8dee))
- Add service for managing files ([4b692c7](https://github.com/KomMonitor/kommonitor-importer/commit/4b692c716fc58499858fd358e6b041d7ca53d972))
- Add test for UploadApiController ([1245e67](https://github.com/KomMonitor/kommonitor-importer/commit/1245e674442aeb62f14db8e2c57ebc46725e4319))
- Add model class for uploaded files ([fa4252c](https://github.com/KomMonitor/kommonitor-importer/commit/fa4252c9efa98092131d502046bcef6058328d49))
- Add support for File based InputStream retrieving ([86df399](https://github.com/KomMonitor/kommonitor-importer/commit/86df3997ab52a310f6215c318bc6fac10fd873ee))
- Add test for HttpRetriever ([0b613f9](https://github.com/KomMonitor/kommonitor-importer/commit/0b613f928cf99611d454fea7a68e454b711a982c))
- Add geojson-jackson dependency ([8fc153f](https://github.com/KomMonitor/kommonitor-importer/commit/8fc153f4e8df2a848914c8d88a7c7bff82a6d0d0))
- Add project structure section to README.md ([22a2ff3](https://github.com/KomMonitor/kommonitor-importer/commit/22a2ff31e462797d8f9714e0b3e4a451103dd5c9))
- Add build anf configuration section to README.md ([fad026a](https://github.com/KomMonitor/kommonitor-importer/commit/fad026a2bfcd3429dc02790835ee50e9be9223ca))
- Add Dockerfile ([1c906a5](https://github.com/KomMonitor/kommonitor-importer/commit/1c906a559de7a23416c5db740438bb5120e2b863))
- Add deployment section to README.md ([2b3fa16](https://github.com/KomMonitor/kommonitor-importer/commit/2b3fa16c4d8abd37d12419d85698cb7f35302e58))
- Add a user guide section to README.md ([532ab29](https://github.com/KomMonitor/kommonitor-importer/commit/532ab292e452407fe421dbf45ce1196efeb97850))
- Add Datasource Definition and Converter Definition to README.md ([71b9d89](https://github.com/KomMonitor/kommonitor-importer/commit/71b9d89a2bcefe517eceaefc45ee03384c659335))
- Add Import sections to README.md ([89fd6c5](https://github.com/KomMonitor/kommonitor-importer/commit/89fd6c5d1d0c9cdc86041937fe734d4f2cdff50d))
- Add PropertyMapping section to README.md ([aefd64b](https://github.com/KomMonitor/kommonitor-importer/commit/aefd64bd7fb23d858d407381cf48abbd5ad830cb))
- Add Indicator mapping and Update Resources parts to README.md ([36b52a9](https://github.com/KomMonitor/kommonitor-importer/commit/36b52a9df4978ba0fc05b64500e10ebc2fa568f5))
- Add class diagram ([08ef223](https://github.com/KomMonitor/kommonitor-importer/commit/08ef223a1c5dfa5e59e85f883fb33f46b2d02db7))
- Add class diagram to README.md ([68ad35d](https://github.com/KomMonitor/kommonitor-importer/commit/68ad35d4aeab131545d7b61f346ca43ad1773058))
- Add Extension section to README.md ([8456ff6](https://github.com/KomMonitor/kommonitor-importer/commit/8456ff6d2d668f30e2ceca27ef8627079187b762))
- Add linebreaks before in-document links ([85a5443](https://github.com/KomMonitor/kommonitor-importer/commit/85a544358c5ec2ca10556a2d901ac726f8ebb7f2))
- Add String porperty parsing for non String values (fixes #3) ([194097a](https://github.com/KomMonitor/kommonitor-importer/commit/194097a21f95f775478bf92a7789acc7da38ce9f))
- Add list of succesfully imported feature IDs to response ([19db095](https://github.com/KomMonitor/kommonitor-importer/commit/19db09583b44b19cb9ba009dbf782f0bd8ae9ff4))
- Add entity validation ([8bfd175](https://github.com/KomMonitor/kommonitor-importer/commit/8bfd175a0eda00f9915539d454b86ed47d8eb8d8))
- Add profile for integration tests ([cc1adee](https://github.com/KomMonitor/kommonitor-importer/commit/cc1adee4450754cccbb980ad8a788679e614c51e))
- Add conversion error monitoring ([c565abb](https://github.com/KomMonitor/kommonitor-importer/commit/c565abbe58630f6d7900e805610a39a2aa7d93dc))
- Add support for parsing Long values as Float (fixes #14) ([d9ffee8](https://github.com/KomMonitor/kommonitor-importer/commit/d9ffee8372561b73e253c9941cb32e033114b3b8))
- Add decoding of integer properties ([fe2f50c](https://github.com/KomMonitor/kommonitor-importer/commit/fe2f50c7737ee32361428447875f27944bdbcd0a))
- Add mapping of additional SimpleFeature attributes ([db21b36](https://github.com/KomMonitor/kommonitor-importer/commit/db21b36a9cbc566fdc5847979aba44500b1204a8))
- Add support for additional parameter encoding as JSON ([5032568](https://github.com/KomMonitor/kommonitor-importer/commit/5032568b50bfefee31ecbf16835ce05ed18a6968))
- Add Long value support for Integer decoding ([0d26732](https://github.com/KomMonitor/kommonitor-importer/commit/0d26732f9c2cd67c2b756500c4b133b0fb37823c))
- Add mapping of alle attributes ([70bd57d](https://github.com/KomMonitor/kommonitor-importer/commit/70bd57dfe7b6fbfa1df0caaa9b67690d46d40d05))
- Add failsafe plugin for running integration tests ([be2e391](https://github.com/KomMonitor/kommonitor-importer/commit/be2e391e28d636c8d8c5bd1c067f6accfbcdb8e0))
- Add gt-csv dependency from geotools to enable CSV parsing with geotools ([3c04057](https://github.com/KomMonitor/kommonitor-importer/commit/3c0405758968ce00b07bc66f83ca36ecf5cd44e6))
- Add tmp forceXY parameter ([79d0671](https://github.com/KomMonitor/kommonitor-importer/commit/79d06712388736b1041e9d5653bce7845cfeb520))
- Add missing or null value handling vor Indicator values ([e972ce1](https://github.com/KomMonitor/kommonitor-importer/commit/e972ce14096f57161ec58dc3f9746c919fe06f26))
- Add monitoring of non critical incidents during conversion ([55c3ee7](https://github.com/KomMonitor/kommonitor-importer/commit/55c3ee716076fc7956b87aa54325ff83e83a75af))
- Add dependency required for Java 9 + ([d02df52](https://github.com/KomMonitor/kommonitor-importer/commit/d02df525783a65c40085f51241dc197759f3f3f1))
- Add an error handling for Data Management specific error messages. Thus enable to forward Data Management Errors to importer clients ([a72577e](https://github.com/KomMonitor/kommonitor-importer/commit/a72577e4f50d86359b39f15790347c6109f3a4d1))
- Add build workflow for CI ([5f9fd55](https://github.com/KomMonitor/kommonitor-importer/commit/5f9fd554b6e97f05d9604a46a41f8d51ed153a4f))
- Add schema aware parsing for indicators ([9b42bed](https://github.com/KomMonitor/kommonitor-importer/commit/9b42beda4fddb347beb1ebd98f8901e8fbd07d1b))
- Add a CSV converter only for indicator imports ([c189782](https://github.com/KomMonitor/kommonitor-importer/commit/c1897825ca28f80abf59e435477e333f7058fc36))
- Add Keycloak adapter ([6db3b0e](https://github.com/KomMonitor/kommonitor-importer/commit/6db3b0e1a63dfe2a5ef2f637298b65dd100857ca))
- Add simple web configuration to allow CORS ([d9ecf75](https://github.com/KomMonitor/kommonitor-importer/commit/d9ecf75acd9c00eb8c7f1aa7c8ced3ab72e6fd73))
- Add BaseController for separate REST context path ([d43e792](https://github.com/KomMonitor/kommonitor-importer/commit/d43e7929ace4b7b6017b7bc3281b5446d3f6ca0e))
- Add Swagger security configuration ([1766387](https://github.com/KomMonitor/kommonitor-importer/commit/1766387f70af27069eb2c5c08ecf725dd6e09f6a))
- Add docker-compose for full stack ([1e52260](https://github.com/KomMonitor/kommonitor-importer/commit/1e52260de0882f1436cdb4453beec7c2fe543a20))
- Add swagger-ui configuration for proxy redirect support ([b40594e](https://github.com/KomMonitor/kommonitor-importer/commit/b40594ed2946a064fed2116284549f85ff272365))
- Add swagger-ui security configuration to support proxy redirection ([0d25f17](https://github.com/KomMonitor/kommonitor-importer/commit/0d25f17f1b8d53d03bbbc4a6e281401d3aa22347))
- Add maven release plugin ([ce46d85](https://github.com/KomMonitor/kommonitor-importer/commit/ce46d85ad0d989e4d9d0c59695dd0161dbb04a87))
- Add github action ([bed8aa0](https://github.com/KomMonitor/kommonitor-importer/commit/bed8aa05bf2127f932c5387ded300447ccf875ad))
- Add docker build cache to github action ([a1a4a49](https://github.com/KomMonitor/kommonitor-importer/commit/a1a4a4956bbbffe2caeec6c8782fcae8ffd4fba0))
- Added changelog auto update during release plugin cycle ([a0bfd18](https://github.com/KomMonitor/kommonitor-importer/commit/a0bfd1834bf5594f0090978f8656fe7cc63aa709))

### Changed

- Initialize project ([4a0a33e](https://github.com/KomMonitor/kommonitor-importer/commit/4a0a33e6397c6562b47bcaf1ea3d9596255e8657))
- Update README ([70c2baf](https://github.com/KomMonitor/kommonitor-importer/commit/70c2baf7d91d170cee934c25b5b3227957c0b0f5))
- Update README.md ([cafac35](https://github.com/KomMonitor/kommonitor-importer/commit/cafac351b61a21044c19ef3d691e28a637acbbc4))
- Move swagger definitions to parent module ([cec96b4](https://github.com/KomMonitor/kommonitor-importer/commit/cec96b4ffe1a983983d1a22cf8db137642b6a8ef))
- Update models and api ([3289d5f](https://github.com/KomMonitor/kommonitor-importer/commit/3289d5fb126e55bdcc9c059ab9cdfaa3d011cd9a))
- Update OpenAPI definitions and generated classes ([6d3512c](https://github.com/KomMonitor/kommonitor-importer/commit/6d3512cb9e68e4316cc56868668f6c1565cd5e7c))
- Extent API schema definitions and update generated classes ([46c8e15](https://github.com/KomMonitor/kommonitor-importer/commit/46c8e15af75f469e454dd5be59468a469234e049))
- Change quantity of supported MIME-types for importers ([0871fd8](https://github.com/KomMonitor/kommonitor-importer/commit/0871fd8d1fdcb189848473e1b0173363b89f6a12))
- Update API definitions ([9e64531](https://github.com/KomMonitor/kommonitor-importer/commit/9e6453192552eee3cec85e0e30155a183d01d03d))
- Initialize core module for providing converter functionalities ([d6f8aef](https://github.com/KomMonitor/kommonitor-importer/commit/d6f8aef747222a6a8125fc9213863f5580833616))
- Refine API error responses ([be02558](https://github.com/KomMonitor/kommonitor-importer/commit/be025581a36fcbe2545a8bdc3ddd1d8311499e96))
- Implement APIcontroller for converters ([fc06686](https://github.com/KomMonitor/kommonitor-importer/commit/fc06686d4574f7eec0af95ffe9c0e1e2c19c7bde))
- Enhance API by datasource types ([3419c84](https://github.com/KomMonitor/kommonitor-importer/commit/3419c840632bf4be9421df7f1249dcc28699e83c))
- Apply small adjustment on API definition ([95f1dba](https://github.com/KomMonitor/kommonitor-importer/commit/95f1dbaf2f18b42309e09a4d2db94cab3200dd97))
- Adjust controller encoding for API response ([cfc9c25](https://github.com/KomMonitor/kommonitor-importer/commit/cfc9c25d9728338700e6563cbe3469215b39f622))
- Implement API for retreiving supported datasource types ([c550c02](https://github.com/KomMonitor/kommonitor-importer/commit/c550c02df07d62c3a8de8bfac4ed722beb5aa293))
- Change abstract importer method signature ([526d494](https://github.com/KomMonitor/kommonitor-importer/commit/526d494e914ff94a6514a40aea5c6b98b6a9b4d7))
- Adjust swagger-codegen config ([2ccb2c2](https://github.com/KomMonitor/kommonitor-importer/commit/2ccb2c2e68f54125ab98a1f0315f057af0dbd86d))
- Rename ConverParameter class ([9fa73af](https://github.com/KomMonitor/kommonitor-importer/commit/9fa73aff17e006e18886401ab7c783540cf1f978))
- Change ConverterRepository to providing AbstractConverter ([14e251a](https://github.com/KomMonitor/kommonitor-importer/commit/14e251ae584288be3fc99e4d1e69f22eedbd670e))
- Move class to another package ([671dd5f](https://github.com/KomMonitor/kommonitor-importer/commit/671dd5fe5dd5fac06f8972cd36c1141c7756891b))
- Rename methods ([1838882](https://github.com/KomMonitor/kommonitor-importer/commit/1838882841dd6762f97e2856256fc87b9142f104))
- Update SpatialResource properties ([0d95479](https://github.com/KomMonitor/kommonitor-importer/commit/0d9547947ac26ed4e6fcfc289323d410b79fd5f4))
- Implement JSON encoder for SpatialResources ([3706817](https://github.com/KomMonitor/kommonitor-importer/commit/3706817ae63a6559d54accbea3f47fea75bb7cdb))
- Apply small refinements ([27b6ebf](https://github.com/KomMonitor/kommonitor-importer/commit/27b6ebf749d3fa4b4bea55e677b1adb8bd17cef8))
- Update GeoTools dependencies ([750c089](https://github.com/KomMonitor/kommonitor-importer/commit/750c0890906aee3aba2bed387829275cd59bfb1c))
- Apply smal adjustments ([cb167ef](https://github.com/KomMonitor/kommonitor-importer/commit/cb167ef4f3adea38e5ee3f4676a5d71aecb49091))
- Adjust POJO ([b31bc49](https://github.com/KomMonitor/kommonitor-importer/commit/b31bc49780580e9357c32a32e62f43fbef0c4071))
- Move ResourceNotFoundException to another package ([4337eb5](https://github.com/KomMonitor/kommonitor-importer/commit/4337eb5f3fdfe3a9b81a80d9fda8d7aad7add418))
- Expand exception handling ([cbe9807](https://github.com/KomMonitor/kommonitor-importer/commit/cbe98077610be07c6915c4f5056968c7fa490068))
- Update JavaDoc ([8c8a645](https://github.com/KomMonitor/kommonitor-importer/commit/8c8a645cd09d97ae3ae71ab7eebaa7d7f3ec96eb))
- Rename methods ([a239a60](https://github.com/KomMonitor/kommonitor-importer/commit/a239a60105333c0a0452c46915de43a3f2c6e425))
- Expand feature decoding tests ([75a56a4](https://github.com/KomMonitor/kommonitor-importer/commit/75a56a45b29ab04d3640bbf6a3af64a05a298249))
- Update API schema definitions ([ba338e9](https://github.com/KomMonitor/kommonitor-importer/commit/ba338e9631579facb0eadc2d20e38f91d4749733))
- Update API schema definitions ([614c5cc](https://github.com/KomMonitor/kommonitor-importer/commit/614c5cc7623851b8eefad84073457ba3159b6e11))
- Enhance Feature decoding ([dcf8471](https://github.com/KomMonitor/kommonitor-importer/commit/dcf8471778651eb55e4c2762aa95ac3058985850))
- Change return type of abstract methods ([3b7e475](https://github.com/KomMonitor/kommonitor-importer/commit/3b7e4752e8d1394696aeddaf68c6354911d9cf0f))
- Apply small code refinements ([e0b377d](https://github.com/KomMonitor/kommonitor-importer/commit/e0b377d852405677a5e3f8014bc0549d8ad938da))
- Expand exception handler for handling HttpMessageNotReadableExceptions ([8e7240b](https://github.com/KomMonitor/kommonitor-importer/commit/8e7240b2559056b05eeca40d301ffe03d11f1040))
- Change usage from JodaTime LocalDate to Java 8 LocalDate ([a66e29a](https://github.com/KomMonitor/kommonitor-importer/commit/a66e29a20f399fc23db2b39679def99bb6685159))
- Delete unused properties file ([bb93732](https://github.com/KomMonitor/kommonitor-importer/commit/bb937321d43ba998d1277f299c790c9005e7aefc))
- Enhance import handler debugging ([af395f6](https://github.com/KomMonitor/kommonitor-importer/commit/af395f661059ee570d6f4e68e11befa70ff3c8e9))
- Expand configuration ([a7c6e81](https://github.com/KomMonitor/kommonitor-importer/commit/a7c6e81ac2e21c057457e065c118547071864882))
- Improve logging ([48b48d9](https://github.com/KomMonitor/kommonitor-importer/commit/48b48d925a618a6f69e4edf29939bb73353d97b7))
- Init test for WFSv1Converter ([eb7d6d2](https://github.com/KomMonitor/kommonitor-importer/commit/eb7d6d22108669824a83ccd4b58e85dde7fd7ce5))
- Integrate converter definition validation into request handler ([8ce1bed](https://github.com/KomMonitor/kommonitor-importer/commit/8ce1bedc564ac28ef624bad9579863abe140ec8f))
- Refine spatial resource converting for different dataset types ([ab412d9](https://github.com/KomMonitor/kommonitor-importer/commit/ab412d949e9a48b8f1a819102a5e118f3af337b2))
- Refactor API model encoding by introducing encoding helper for common API types ([666e562](https://github.com/KomMonitor/kommonitor-importer/commit/666e56294f0faa72848831930679ac4fee749842))
- Moce locatio header constant to abstract superclass ([0948777](https://github.com/KomMonitor/kommonitor-importer/commit/094877779eaa6d29e55bd54c5a85c9ed79519f1d))
- Implement SpatialUnit importing ([cd2de49](https://github.com/KomMonitor/kommonitor-importer/commit/cd2de49ea220469931c7dedbc7f2d0eeb03b4eb8))
- Refine logging ([8f5b128](https://github.com/KomMonitor/kommonitor-importer/commit/8f5b128e2c7563a2185574cda0ae329f539fe6e8))
- Rename class ([4d0b26f](https://github.com/KomMonitor/kommonitor-importer/commit/4d0b26f0b400599cd9b540d711519a140803d902))
- Improve logging ([4332d52](https://github.com/KomMonitor/kommonitor-importer/commit/4332d520e37ac7b1683c4b294eb4f85cbf111369))
- Implement Indicator import endpoint ([7728fb3](https://github.com/KomMonitor/kommonitor-importer/commit/7728fb39c1d62766287d77cb0029adb0732ec9b9))
- Adjust tests due to added geometry reprojection ([a491f66](https://github.com/KomMonitor/kommonitor-importer/commit/a491f663124390387e20196e638086ceae1b4ab3))
- Adjust feature decoding ([9fbe20b](https://github.com/KomMonitor/kommonitor-importer/commit/9fbe20bdf659d0c0403edaf611217ddbffec9515))
- Move geometry reprojection to GeometryHelper ([a4562e2](https://github.com/KomMonitor/kommonitor-importer/commit/a4562e269707ef6ab7845ac1acd77ad4847ac2bd))
- Move datamanagement API client into KomMonitor importer project ([a15aeb5](https://github.com/KomMonitor/kommonitor-importer/commit/a15aeb53a186c62fcee643718443472825a67678))
- Configure Maven build profile to unpack OpenAPI specs artifact ([35aefd5](https://github.com/KomMonitor/kommonitor-importer/commit/35aefd542e83ade19063ee1e3827e0fcb3855dac))
- Update model classes ([b8c4392](https://github.com/KomMonitor/kommonitor-importer/commit/b8c4392d4a53321e1a63b9ecbdc701b802253fa7))
- Update .gitignore ([0c6dcb4](https://github.com/KomMonitor/kommonitor-importer/commit/0c6dcb4b815f55c63ad3f62a3da56a97c6569ff8))
- Adjust models to latest schema definition changes ([09dee88](https://github.com/KomMonitor/kommonitor-importer/commit/09dee88dbffac1e64e5e2f5718ef59f4f5173e7e))
- Adjust converter to model changes ([536fab5](https://github.com/KomMonitor/kommonitor-importer/commit/536fab5177f10ca97e2b03b62e9bd3fd7ab67855))
- Update API controller ([01032f4](https://github.com/KomMonitor/kommonitor-importer/commit/01032f457ed90b0471e5f76f4128da715732253a))
- Improve converter definition validation ([e87df20](https://github.com/KomMonitor/kommonitor-importer/commit/e87df207fd16f94035bb7b8519cd3fe9016969a0))
- Update README ([31fa444](https://github.com/KomMonitor/kommonitor-importer/commit/31fa444ea35a030f28927b705eceaec6c85702d2))
- Enhance testing ([db6b688](https://github.com/KomMonitor/kommonitor-importer/commit/db6b688ddf0905b71db9cb68ccba1c7d6d9026df))
- Update importer models ([00ca95a](https://github.com/KomMonitor/kommonitor-importer/commit/00ca95abd1e112ec33bcefeda4c891d9652f8cd5))
- Change API code generation ([dae4b9f](https://github.com/KomMonitor/kommonitor-importer/commit/dae4b9f278c608d78782f145eb38385fb8cde327))
- Adjust API client and models ([aa3fc9a](https://github.com/KomMonitor/kommonitor-importer/commit/aa3fc9a7660a6d9961a68a1cdac75d451ee73fe4))
- Update importer schema definitions ([7348edd](https://github.com/KomMonitor/kommonitor-importer/commit/7348edd91673d5be3a05f4cd557d8493f302950f))
- Adjust API client to different model sources ([7d5fbac](https://github.com/KomMonitor/kommonitor-importer/commit/7d5fbac4fb381c61a1d7e121e1883970ae9e2504))
- Adjust tests ([22a0d45](https://github.com/KomMonitor/kommonitor-importer/commit/22a0d452ec0eb90c4c20f2659c2391647f0f1a72))
- Introduce common model module ([2d0516f](https://github.com/KomMonitor/kommonitor-importer/commit/2d0516fe71c06821de2bb44af73431a8fc47ba3f))
- Prepare models for update endpoint ([12e9924](https://github.com/KomMonitor/kommonitor-importer/commit/12e992435110a1998028fe0c5aaf259568877d83))
- Adjust imports due to introduced common model module ([2cfc9d4](https://github.com/KomMonitor/kommonitor-importer/commit/2cfc9d4fa26f5d67bca3ec4330937bf942c92416))
- Generate API update endpoints ([8b6fb26](https://github.com/KomMonitor/kommonitor-importer/commit/8b6fb26311feb761d87aafcaaf407100b82c66d8))
- Implement update request handling ([81e8c42](https://github.com/KomMonitor/kommonitor-importer/commit/81e8c4271a4c2258a3d346fa56016389a83daee7))
- Implement update API endpoint controllers ([a824d3f](https://github.com/KomMonitor/kommonitor-importer/commit/a824d3fdc1b4f6c0723ca041635cbc216f6e0732))
- Introduce repository for request handlers ([964664c](https://github.com/KomMonitor/kommonitor-importer/commit/964664cd24cabb55452945a87b2ff34cbf48d8ee))
- Apply small refinements ([efd6c75](https://github.com/KomMonitor/kommonitor-importer/commit/efd6c75c273ba9c4061bceddb14e3fb97e709d2a))
- Refine logging messages ([e294d1b](https://github.com/KomMonitor/kommonitor-importer/commit/e294d1bcd28f4648cbb166ee3f02eb914f248b09))
- Generate API classes for update endpoint ([4c86cba](https://github.com/KomMonitor/kommonitor-importer/commit/4c86cba244fab4f809a7203ed65be94be9869794))
- Expand Indicator type by adding optional timestamp attribute ([152f74c](https://github.com/KomMonitor/kommonitor-importer/commit/152f74c4863a3962817ce0fa10f65eb08a711816))
- Adjust feature decoding to optional timestamp property for Indicator mappings ([1ed2a5b](https://github.com/KomMonitor/kommonitor-importer/commit/1ed2a5b7dc91d11f0d5e89bfe00e1ccc3504ea45))
- Exapnd Indicator property mapping by enabling multiple mappings ([9d3489f](https://github.com/KomMonitor/kommonitor-importer/commit/9d3489f0ccb4415717a8a808d0d7172ba8f1ea81))
- Introduce TimeseriesMapping for Indicator values ([a04306a](https://github.com/KomMonitor/kommonitor-importer/commit/a04306a48bb882d91d79c83f705b7551d6bf54f7))
- Adjust feature decoding to introduced TimeseriesPropertyMapping ([df51450](https://github.com/KomMonitor/kommonitor-importer/commit/df51450a4a963cdf19cb6c3becf55b8d30582922))
- Merge branch 'develop' into feature/fileUpload ([d2fe472](https://github.com/KomMonitor/kommonitor-importer/commit/d2fe4724489933a2d197f4df72c2b9e7118b88c5))
- Implement file upload endpoint ([cf0ee55](https://github.com/KomMonitor/kommonitor-importer/commit/cf0ee5571b2110e53fe5859962c8e65f431cabc1))
- Rename ApiExceptionHandler ([1cc1eaa](https://github.com/KomMonitor/kommonitor-importer/commit/1cc1eaa13adf6f960249d2c9192bfcf7bb2c3970))
- Expand FileStorageService by storing metadata information ([50a9702](https://github.com/KomMonitor/kommonitor-importer/commit/50a97022f7564313555c9c0df6d6b4b1606ea56c))
- Implement UploadApiController endpoint for uploaded file retrieving ([0f4a8a2](https://github.com/KomMonitor/kommonitor-importer/commit/0f4a8a2bb4f6602af5bcb94b112b3662ec52e795))
- Implement FileRetriever and add test ([fd64a98](https://github.com/KomMonitor/kommonitor-importer/commit/fd64a988f77c9e07c9d53d573a8fb8d7ddd8e603))
- Move testing method to AbstractConverter test class ([1cdaadd](https://github.com/KomMonitor/kommonitor-importer/commit/1cdaadd00d7b95f229a4324cefed55598e91609e))
- Refactor single Feature to IndicatorValue decoding ([afd9a70](https://github.com/KomMonitor/kommonitor-importer/commit/afd9a701fed036dcd419f51fe91c695793cb5c14))
- Implement GeoJsonConverter ([1b04adc](https://github.com/KomMonitor/kommonitor-importer/commit/1b04adca245c9648b5ac4ebed882f13501c5d400))
- Apply small fixes ([7859f25](https://github.com/KomMonitor/kommonitor-importer/commit/7859f2552a66bc83c51c41bf3010ded233829e3c))
- Rename abstract method ([8f81fa5](https://github.com/KomMonitor/kommonitor-importer/commit/8f81fa5357346ce002b4858e80746169c7c41bc6))
- Apply various renamings ([b55d186](https://github.com/KomMonitor/kommonitor-importer/commit/b55d18627ebf83ae2dd852c9da71149a20ed9182))
- Update README.md ([7939cf6](https://github.com/KomMonitor/kommonitor-importer/commit/7939cf6525cd362593c15f2472d40b73e9a46a77))
- Restructure README.md ([320c98c](https://github.com/KomMonitor/kommonitor-importer/commit/320c98c9e57b33b19f9971a192a89dd332920c62))
- Apply more detailed float number parsing ([27be687](https://github.com/KomMonitor/kommonitor-importer/commit/27be68728d59d1faae2e6cfbc429f09149d7a083))
- Adjust class diagram ([81be2a5](https://github.com/KomMonitor/kommonitor-importer/commit/81be2a5bc60657f041093f933f2d9e038b86c28b))
- Revise README.md ([2c6144b](https://github.com/KomMonitor/kommonitor-importer/commit/2c6144bb6109d642f233001859fc1fdd40c0f14a))
- Update models ([2d48289](https://github.com/KomMonitor/kommonitor-importer/commit/2d48289fac42ecf0bf0ebb9ace5e1cbce37139e5))
- Update API and controller class for extended response type ([1ca9134](https://github.com/KomMonitor/kommonitor-importer/commit/1ca9134a4ed6c2f11ca21a4b906320b856f7134c))
- Improve Exception handling ([ae244de](https://github.com/KomMonitor/kommonitor-importer/commit/ae244dee342c8f1e63e1fb3ea0a1b10c903741f5))
- Rearrange feature decoding methods ([3bf994b](https://github.com/KomMonitor/kommonitor-importer/commit/3bf994bc026b834814ef33e749f0b0a66dff44d7))
- Rename integration test classes ([39f4f1a](https://github.com/KomMonitor/kommonitor-importer/commit/39f4f1a638ecfc66e18aacfe07e8514c232c372d))
- Rename integration tests classes ([588a308](https://github.com/KomMonitor/kommonitor-importer/commit/588a3080703643dec3cd4ed5add14b9c6380e4b9))
- Implement handling for dry run requests ([5177297](https://github.com/KomMonitor/kommonitor-importer/commit/5177297a41b0e6b6bc55fd5c498d0b00e5ea0639))
- Adjust API integration tests ([02c3aac](https://github.com/KomMonitor/kommonitor-importer/commit/02c3aacd9469214a54478eab74dc85b25f4390f5))
- Update models ([1738e8a](https://github.com/KomMonitor/kommonitor-importer/commit/1738e8ade4b1f07aae10a02342a435f226316e6a))
- Expand monitoring class ([8accc6f](https://github.com/KomMonitor/kommonitor-importer/commit/8accc6f9c30ffabf3c202088c5f20ddfe14cd64a))
- Update sequence diagrams ([e8145d2](https://github.com/KomMonitor/kommonitor-importer/commit/e8145d24febddcfec3437a2493ba975702f0cedd))
- Update README.md ([49b0299](https://github.com/KomMonitor/kommonitor-importer/commit/49b0299a0f89c0c371dced992301bea074f903a6))
- Adjust integration tests ([d3da65e](https://github.com/KomMonitor/kommonitor-importer/commit/d3da65e8c114d5c5dd06e95890177c96582c7a0b))
- Use valid resources for encoding ([ebc9f68](https://github.com/KomMonitor/kommonitor-importer/commit/ebc9f684f1faf9f12934c4ca5f30f517f8bb5010))
- Adjust validation logging to fix #11 ([6f910cc](https://github.com/KomMonitor/kommonitor-importer/commit/6f910ccbd764c326ba760f4987d6297be5264050))
- Improve exception handling for CRS parameter decoding ([d2fd18a](https://github.com/KomMonitor/kommonitor-importer/commit/d2fd18a45430c2de5c174bb5d8c9b3671cc11a12))
- Provide configuration paramteters for uploading file size ([8f3aa18](https://github.com/KomMonitor/kommonitor-importer/commit/8f3aa189d243365cce8664951aab5502ebb341c7))
- Refine docker build ([fe9f784](https://github.com/KomMonitor/kommonitor-importer/commit/fe9f78463fde8b92dfb7560fb869dd656ffc2c45))
- Update models ([b450b1d](https://github.com/KomMonitor/kommonitor-importer/commit/b450b1db37de97e7d03f295947377d32b25a108e))
- Update models ([83baca8](https://github.com/KomMonitor/kommonitor-importer/commit/83baca876962bf01b19f56fdaa9cce18c7f97ae7))
- Update README.md for attribute mappings ([c0834e2](https://github.com/KomMonitor/kommonitor-importer/commit/c0834e25c399c8a58832c3ae301baf2afe6f4d46))
- Merge branch 'develop' into feature/attribute-mapping ([cea2b43](https://github.com/KomMonitor/kommonitor-importer/commit/cea2b43b3a68c8d5c757f54bbc3f536b177aecfb))
- Adjust mapping all attributes by filtering out the geometry property ([a1fd6c1](https://github.com/KomMonitor/kommonitor-importer/commit/a1fd6c1215f90d204d3e8ffb2dcea7da327815dc))
- Apply code refinements ([ae86501](https://github.com/KomMonitor/kommonitor-importer/commit/ae8650172ef7848303a6a005c9a63c2f54fd7cd5))
- Implement draft for CSV converter ([14577a0](https://github.com/KomMonitor/kommonitor-importer/commit/14577a0e012954de0d2de2d71f66efcad20b25ad))
- Increase file upload size ([8116fd1](https://github.com/KomMonitor/kommonitor-importer/commit/8116fd13dd66ae2476dab5e5aa56f022155fdddb))
- Merge branch 'develop' of https://github.com/SebaDro/kommonitor-importer into develop ([e0e3f94](https://github.com/KomMonitor/kommonitor-importer/commit/e0e3f946bf1330ddd94aa103320b8b570ad6ec34))
- Merge branch 'develop' of https://github.com/SebaDro/kommonitor-importer into develop ([aab579a](https://github.com/KomMonitor/kommonitor-importer/commit/aab579a8e9f089ed8435e059655d90e81bab5ac1))
- Implement IndicatorValue grouping for GeoJsonConverter ([7511610](https://github.com/KomMonitor/kommonitor-importer/commit/7511610bb9cd8ada1e53a5396684864dc7ca0718))
- Merge branch 'develop' of https://github.com/SebaDro/kommonitor-importer into develop ([b1ace42](https://github.com/KomMonitor/kommonitor-importer/commit/b1ace423dcfa77af9605ef2cfde25a936eca24d4))
- Update GeoTools repository ([dd8d4d8](https://github.com/KomMonitor/kommonitor-importer/commit/dd8d4d8f626c08a7405261caa41e906334bad2e4))
- Merge branch 'develop' ([d234079](https://github.com/KomMonitor/kommonitor-importer/commit/d2340797038c70ed75c12bebf24ef8600b03cdf4))
- Update models ([751ab36](https://github.com/KomMonitor/kommonitor-importer/commit/751ab36039d166b4ba96d66c9249956c5bb610fd))
- Refactor property decoding for string and integer values ([038b9a7](https://github.com/KomMonitor/kommonitor-importer/commit/038b9a7e6d3f35d37f826ec9e9a03b3831536ca3))
- Refactor property decoding for Float values ([cc8bff9](https://github.com/KomMonitor/kommonitor-importer/commit/cc8bff9d58fe45621ee6efa650e6310a55bb989b))
- Refactor property decoding for LocalDate values ([c9f5d5c](https://github.com/KomMonitor/kommonitor-importer/commit/c9f5d5c1500dfa20ca1c2d236490f81c96279e27))
- Implement missing or null value property handling ([9ac81f9](https://github.com/KomMonitor/kommonitor-importer/commit/9ac81f9f59abcc9381f4997bdc26fc87c57b99a8))
- Update models ([6df5f47](https://github.com/KomMonitor/kommonitor-importer/commit/6df5f475b4ac53cc872a3e7c51c577da95d0ee66))
- Apply small code refinements ([92d162d](https://github.com/KomMonitor/kommonitor-importer/commit/92d162db6abe09b745b27e5b587fe3d2403882bd))
- Adjusts tests to null value handling ([b79f794](https://github.com/KomMonitor/kommonitor-importer/commit/b79f7948d0171b04d64a3f872792877010c97fa6))
- Update models ([15fcde7](https://github.com/KomMonitor/kommonitor-importer/commit/15fcde79f8dae2e35e7fbd4975313102309e141a))
- Change boolean getter signature to support null validation ([ad899e9](https://github.com/KomMonitor/kommonitor-importer/commit/ad899e9c4cc7a4bea8c58fa4f982ad1199daebd6))
- Improve validation for missing value handling cases ([3a2ad59](https://github.com/KomMonitor/kommonitor-importer/commit/3a2ad59efdaecd9d2b72e0f4b057de3c0707f825))
- Update models to include warning messages withing response ([25bb166](https://github.com/KomMonitor/kommonitor-importer/commit/25bb1664a83438a580b8ffa091ed1a87aefdd523))
- Update README by adding instructions for missing value handling ([77ffa7c](https://github.com/KomMonitor/kommonitor-importer/commit/77ffa7ceb25a2e014b72f95744d8b4662268ba50))
- Improve handling and logging for upload file exceptions ([57f20f6](https://github.com/KomMonitor/kommonitor-importer/commit/57f20f66c46e19cc3a9bd808d9d1d3f64fd2f2f2))
- Merge branch 'develop' of https://github.com/SebaDro/kommonitor-importer into develop ([6efb328](https://github.com/KomMonitor/kommonitor-importer/commit/6efb32890bd058158f74d9dfdbb9a678756e2afb))
- Merge branch 'develop' into feature/csvDataSource ([c867a4a](https://github.com/KomMonitor/kommonitor-importer/commit/c867a4ad99ce480cb45eea57a78dcc733b2578a0))
- Catch all types of Exceptions ([f73fc68](https://github.com/KomMonitor/kommonitor-importer/commit/f73fc6811ea653f85a144f769360b28125697220))
- Merge branch 'develop' into feature/csvDataSource ([7601746](https://github.com/KomMonitor/kommonitor-importer/commit/7601746b031e0bd73819737521d4ec45c827f162))
- Enable CORS ([7fa725e](https://github.com/KomMonitor/kommonitor-importer/commit/7fa725ef5b8a75af2375216fe85bd126932c0d57))
- Merge branch 'develop' into feature/csvDataSource ([824e328](https://github.com/KomMonitor/kommonitor-importer/commit/824e3280a78e0d4a7a69064d749ffc9108325822))
- Make attribute decoding more agnostic to different types ([d5a61ab](https://github.com/KomMonitor/kommonitor-importer/commit/d5a61abd8c897824cb6772c76095bd6423a7093d))
- Merge branch 'master' of https://github.com/SebaDro/kommonitor-importer ([821d8f0](https://github.com/KomMonitor/kommonitor-importer/commit/821d8f02f1c4db949fea19d8e55231415045a565))
- Merge branch 'master' into develop ([14d7bbd](https://github.com/KomMonitor/kommonitor-importer/commit/14d7bbdb5b9f3ce70e4e5880da582d3b2f985b60))
- Move API client error handling to ApiExceptionHandler ([f5b5b64](https://github.com/KomMonitor/kommonitor-importer/commit/f5b5b644328cd008382fd64030ae21afb4a8a1df))
- Improve null value encoding ([0aeb82e](https://github.com/KomMonitor/kommonitor-importer/commit/0aeb82e4d1232c3db47dae333db9a531b55120b4))
- Merge branch 'develop' into feature/csvDataSource ([7779615](https://github.com/KomMonitor/kommonitor-importer/commit/77796156d396f82c9d62513c63fea541089e64cf))
- Skip tests on docker build ([b6c9548](https://github.com/KomMonitor/kommonitor-importer/commit/b6c9548505ab6301b8d5f208b8ba5dc216755d04))
- Introduce session timeout setting in application.yml to optionally increase timeout for larger dataset imports ([a1f7e11](https://github.com/KomMonitor/kommonitor-importer/commit/a1f7e112114e0dca08fb172d44e7f8ba1dc9c4f4))
- Merge branch 'develop' into feature/csvDataSource ([f241554](https://github.com/KomMonitor/kommonitor-importer/commit/f241554100b86ed4ff7f3d44e70074f964ff9355))
- Increase default and configured timeouts for REST CLIENT ([f07b0bc](https://github.com/KomMonitor/kommonitor-importer/commit/f07b0bc0b3e8b2838eedc5bbc8c09ac46e94432e))
- Implement schema aware FeatureCollection parsing ([8ee5dfc](https://github.com/KomMonitor/kommonitor-importer/commit/8ee5dfc28027d996b815b8eb91752a8346a4a443))
- Merge branch 'develop' of https://github.com/SebaDro/kommonitor-importer into develop ([39cddc5](https://github.com/KomMonitor/kommonitor-importer/commit/39cddc50496a8a6a4672ac30cb9f0f7b7a1ce494))
- Merge branch 'develop' into feature/csvDataSource ([db0ceb8](https://github.com/KomMonitor/kommonitor-importer/commit/db0ceb80d2028336d7cd28c202ce8cd761911550))
- Allow validEndDate property value for each feature to have the value 'null' ([6b49849](https://github.com/KomMonitor/kommonitor-importer/commit/6b4984982c73d66b7d01d9e97ec3b36772449b3b))
- Merge branch 'develop' into feature/csvDataSource ([f7e9b9d](https://github.com/KomMonitor/kommonitor-importer/commit/f7e9b9de335f4d323ef580d1c4e45fb45c5cf9f6))
- Update models ([9f52487](https://github.com/KomMonitor/kommonitor-importer/commit/9f524878de54f91ef2a77fefd316724aeb39b6e9))
- Enhance ParameterType by adding a mandatory flag ([bc34d27](https://github.com/KomMonitor/kommonitor-importer/commit/bc34d274ac103eaa15b1a20f3505df260bb0d13c))
- Merge branch 'develop' into feature/csvDataSource ([16a7290](https://github.com/KomMonitor/kommonitor-importer/commit/16a72909b90c9fc91bc736bdc224394b2bd0d1fe))
- Adjust csvConverter to new mandatory parameter value ([f4d40c7](https://github.com/KomMonitor/kommonitor-importer/commit/f4d40c760b232f5e8abf830be25b56c137047ace))
- Enhance parameter validation ([d3b521b](https://github.com/KomMonitor/kommonitor-importer/commit/d3b521bde842245830450e22d19b664ad3ae383c))
- Merge branch 'develop' into feature/csvDataSource ([a5c12be](https://github.com/KomMonitor/kommonitor-importer/commit/a5c12be9db30f6b8f58bf8fbccd6a8c1d47b20ef))
- Enhance float value parsing ([24c8abb](https://github.com/KomMonitor/kommonitor-importer/commit/24c8abba499f3029242a1ad30c2314774b04b9bc))
- Merge branch 'develop' into feature/csvDataSource ([d25245d](https://github.com/KomMonitor/kommonitor-importer/commit/d25245dbe9b2e803974436eb8b591707dd6dad0d))
- Create LICENSE ([33a8a8d](https://github.com/KomMonitor/kommonitor-importer/commit/33a8a8d1604a7dfb3749b480353e37aa80de7b3c))
- Merge branch 'master' into develop ([90937b1](https://github.com/KomMonitor/kommonitor-importer/commit/90937b1349f2e2fab48bf65e57f4cb00a01bd568))
- Reformat code ([cd3d20d](https://github.com/KomMonitor/kommonitor-importer/commit/cd3d20d114c6a0ace4c8c1dd2189e0512f97d181))
- Provide a Keycloak specific RestTemplate customizer for intercepting HTTP request ([9c4fb86](https://github.com/KomMonitor/kommonitor-importer/commit/9c4fb86d00e7a476b665f2ae53543b3d9b68a9e7))
- Merge branch 'master' into feature/keycloakAuth ([086ac05](https://github.com/KomMonitor/kommonitor-importer/commit/086ac05832518041f7746a58944b34c70cc626b3))
- Update models for role based access control ([c1b7b99](https://github.com/KomMonitor/kommonitor-importer/commit/c1b7b99e54d807f42be56859192667bdbe6ca63f))
- Merge branch 'master' into feature/keycloakAuth ([ab4ad0c](https://github.com/KomMonitor/kommonitor-importer/commit/ab4ad0cb3df566bea14bcc64c0d0bb17eba400bc))
- Adjust importer to changed Data Management API ([a793e5c](https://github.com/KomMonitor/kommonitor-importer/commit/a793e5cd5f15c597044f42b2acdaa60f065342db))
- Make RestTemplate customizing for Keycloak optional ([e15b003](https://github.com/KomMonitor/kommonitor-importer/commit/e15b0031e6d59d7439aa2213c9eb69c87d08ce9c))
- Merge branch 'develop' into feature/keycloakAuth ([3c7a052](https://github.com/KomMonitor/kommonitor-importer/commit/3c7a0524263e0f5e0ed6c020ee46adb87e3842dd))
- Merge branch 'feature/csvDataSource' into feature/keycloakAuth_deployment ([c183a87](https://github.com/KomMonitor/kommonitor-importer/commit/c183a877610f714e34fabf2cb6cc4b66cbf19ca8))
- Merge branch 'develop' into feature/keycloakAuth ([935dc4d](https://github.com/KomMonitor/kommonitor-importer/commit/935dc4d7e4b831873491456fa3756ee5afc43c8a))
- Merge branch 'feature/keycloakAuth' into feature/keycloakAuth_deployment ([1817498](https://github.com/KomMonitor/kommonitor-importer/commit/1817498e81fb898707fd3348a952af17d667db22))
- Merge branch 'feature/csvDataSource' into feature/keycloakAuth_deployment ([c168f20](https://github.com/KomMonitor/kommonitor-importer/commit/c168f20a64e92e0fa3f51a44d08fd2d6ab99945b))
- Merge branch 'develop' into feature/keycloakAuth_deployment ([a7ee85f](https://github.com/KomMonitor/kommonitor-importer/commit/a7ee85f058594178e9d70604a2677f6cb6d98254))
- Merge branch 'feature/csvDataSource' into feature/keycloakAuth ([ecc5fe6](https://github.com/KomMonitor/kommonitor-importer/commit/ecc5fe6c1b75b098e69cae3e1418d2b3237b3b6d))
- Merge branch 'master' into feature/keycloakAuth ([537d5c1](https://github.com/KomMonitor/kommonitor-importer/commit/537d5c146bea0e2afc51aec77b6b5d4465d81364))
- Merge branch 'feature/keycloakAuth' into feature/keycloakAuth_deployment ([46b297c](https://github.com/KomMonitor/kommonitor-importer/commit/46b297ca4cde62fb8661ac4ab0d57eb7b58dba0c))
- Merge branch 'feature/keycloakAuth_deployment' into develop ([4a234a4](https://github.com/KomMonitor/kommonitor-importer/commit/4a234a49acf1ac4cdd71f05eae25b19f3d504d60))
- Default keycloak to false ([52904b9](https://github.com/KomMonitor/kommonitor-importer/commit/52904b997a2c630214c56f8876421c921029512d))
- Set coordinate axis parameter within code directly. ([5883888](https://github.com/KomMonitor/kommonitor-importer/commit/5883888d254c785d67d312634339a6ea4c02fedc))
- Reset version of parent pom to 0.0.1 ([24027a7](https://github.com/KomMonitor/kommonitor-importer/commit/24027a726753ca901f65531917ec933603718c2f))
- Create dockerhub-latest.yml ([0990350](https://github.com/KomMonitor/kommonitor-importer/commit/099035046974865e533c0c28ee57007cf860b351))
- Adjust README and insert new github action to sync README_DOCKERHUB.md with docker repository ([2a29eb5](https://github.com/KomMonitor/kommonitor-importer/commit/2a29eb52b53052edbdb821277acf609a2d29345f))
- Improve code markup ([f5f6e7e](https://github.com/KomMonitor/kommonitor-importer/commit/f5f6e7e2e4f3c232ebc0141d22842cd6287bc1c0))
- Sort parsed timeseries value pairs by timestamp ascending to ensure that each feature is submitted in the same timestamp order to management component ([b13b35d](https://github.com/KomMonitor/kommonitor-importer/commit/b13b35d9ad1c5c787e4988aa4511a40c416f8ad1))
- Changed github actions ([8a5121d](https://github.com/KomMonitor/kommonitor-importer/commit/8a5121df2a8a1b21d0753bdb4456a26e6deb01c8))
- Changed SCM tag info in POM ([3c02801](https://github.com/KomMonitor/kommonitor-importer/commit/3c028019c86b661116efb0526f0c48bce28abdc0))
- [maven-release-plugin] Update CHANGELOG.md ([fe68e91](https://github.com/KomMonitor/kommonitor-importer/commit/fe68e91819f9361672d9b0a66596030454ca8140))
- [maven-release-plugin] prepare release 1.0.0 ([3956b07](https://github.com/KomMonitor/kommonitor-importer/commit/3956b076e14f74318cd2147fb5aa11e4863405c9))

### Fixed

- Fix error code type ([8e5b7c9](https://github.com/KomMonitor/kommonitor-importer/commit/8e5b7c9a752b8b117c5f624266e02711ae6bb007))
- Fix typo ([7478119](https://github.com/KomMonitor/kommonitor-importer/commit/74781197358bd3a0952d0f000bd7562c66104801))
- Fix encoding ([12dd072](https://github.com/KomMonitor/kommonitor-importer/commit/12dd072fd339d5394d459a566f49073a42c6c39e))
- Fix failing tests ([1742249](https://github.com/KomMonitor/kommonitor-importer/commit/1742249e7fe08996936fefd142877f5e5aeb091c))
- Fix missing @Component ([bfa6989](https://github.com/KomMonitor/kommonitor-importer/commit/bfa6989689c5f93a5ced027d9b06fa5c537dcee5))
- Fix wording in README.md ([4d39304](https://github.com/KomMonitor/kommonitor-importer/commit/4d393043c196b7e00cf827d76aba8f2fb294281a))
- Fix JSON snippings ([594bf1d](https://github.com/KomMonitor/kommonitor-importer/commit/594bf1dfbf2c3557686da76426371755496b7367))
- Fix Swagger annotations ([02a83eb](https://github.com/KomMonitor/kommonitor-importer/commit/02a83eb795627546ce15ddc2f6a60c869abc2848))
- Fix tests ([9ea6bc7](https://github.com/KomMonitor/kommonitor-importer/commit/9ea6bc75a38a5b735e8860d8d110605ab3ebc2dd))
- Fix logging ([96383cc](https://github.com/KomMonitor/kommonitor-importer/commit/96383cc44f1a11f788eaa4cf83800db1da462ec8))
- Fix immutable error list ([937b89e](https://github.com/KomMonitor/kommonitor-importer/commit/937b89e6f956620469a228e1378aaac1d8c30a57))
- Fix #6 ([ea4af5b](https://github.com/KomMonitor/kommonitor-importer/commit/ea4af5b412d2e85bcd97558b4eca05fb8e3839b0))
- Fix test fail which come up with d2fd18a ([ceba96a](https://github.com/KomMonitor/kommonitor-importer/commit/ceba96aba81fc41a9d723ac72f751090d1d98779))
- Fix tests ([297f19a](https://github.com/KomMonitor/kommonitor-importer/commit/297f19acc1fde4653cc311fc010243c16b25fbc1))
- Fix tests due to introduced null value handling flag ([94ef944](https://github.com/KomMonitor/kommonitor-importer/commit/94ef944fdc6ceb8dead5637dfdd6581775dc29ac))
- Fix missing value handling ([eb4d173](https://github.com/KomMonitor/kommonitor-importer/commit/eb4d173670b713108c824168c7adc8f90286f7df))
- Fix tests ([85da652](https://github.com/KomMonitor/kommonitor-importer/commit/85da65265a79026d594cf98fd05b437826bf616b))
- Fix test ([fdacfc7](https://github.com/KomMonitor/kommonitor-importer/commit/fdacfc7e13fa3d19f66d7e719e3ca3e1a48675eb))
- Fix response status code for API client errors ([d9dbcf8](https://github.com/KomMonitor/kommonitor-importer/commit/d9dbcf837761b05664e3655414e5e6b437f0c5db))
- Fix REST controler integration tests ([35bcc2b](https://github.com/KomMonitor/kommonitor-importer/commit/35bcc2b90b7b344bd71c44d43e89fcbdef56636a))
- Testwise unset default content-typ header to test if this may cause issues in production ([e642804](https://github.com/KomMonitor/kommonitor-importer/commit/e6428043d1d0aa43ec8149db4359e90f7b230de6))
- Fix application.yml --> instead of tabs make use of whitespaces ([dfbca5f](https://github.com/KomMonitor/kommonitor-importer/commit/dfbca5ffbce41a0b1fec53a231fb7b6d50746200))
- Fix application.yml indent ([dcc7d09](https://github.com/KomMonitor/kommonitor-importer/commit/dcc7d09f434c9e4a221b856baa208be69d1bde5b))
- Fix geometry GeoJSON output generation process; it only forwared 4 decimals prior to this fix; now up to 13 decimals ([6fdcfed](https://github.com/KomMonitor/kommonitor-importer/commit/6fdcfed698bc77b9229a2dae6250d29e31f08673))
- Fix integration tests ([096cc05](https://github.com/KomMonitor/kommonitor-importer/commit/096cc05d8e44505410b446f5ce08280fc5c43e1f))
- Fix unit tests ([186c66d](https://github.com/KomMonitor/kommonitor-importer/commit/186c66ddf0a14ce8593f2204e08853ea1162af5a))

### Removed

- Remove API client module ([9369663](https://github.com/KomMonitor/kommonitor-importer/commit/936966318f786339c8664060aebaa8e132699792))
- Remove unuse encoder ([84b959e](https://github.com/KomMonitor/kommonitor-importer/commit/84b959ef626e3763f8bdccc422c3324661ea2e06))
- Remove unused field ([feeabd8](https://github.com/KomMonitor/kommonitor-importer/commit/feeabd8918b755f15deb13f96f13cd2c78dd5c1b))
- Remove unused fields ([d9e04fe](https://github.com/KomMonitor/kommonitor-importer/commit/d9e04fe29b5f7197a4e6bb9390c0b7ebf6d443e2))
- Remove OpenAPI specification docs ([5825b46](https://github.com/KomMonitor/kommonitor-importer/commit/5825b46db36dd278fad202c61c6783d33dc803e1))
- Remove unused encoding classes and methods ([6e7c37d](https://github.com/KomMonitor/kommonitor-importer/commit/6e7c37def7a38e3a0f01ccd92be0d898d5536c97))
- Remove geoJsonString from toString() ([fabcecb](https://github.com/KomMonitor/kommonitor-importer/commit/fabcecbdfeb8dc4552c0078ab78f37803912e21d))
- Remove geojson property from toString() ([d6ec6b7](https://github.com/KomMonitor/kommonitor-importer/commit/d6ec6b7f1adff1acb852f9a9c225d6bd3e2bdcf3))
- Remove unsued dependencies ([0666edc](https://github.com/KomMonitor/kommonitor-importer/commit/0666edcf1d7de156112fbb4020626a6a60a86f5f))
- Remove unused test  file ([366f3e8](https://github.com/KomMonitor/kommonitor-importer/commit/366f3e80356b7e733fa11c5172275e308f58fa96))
- Remove outdated swagger files ([792a94e](https://github.com/KomMonitor/kommonitor-importer/commit/792a94e911f95791d38f65897747fcda062efbca))
- Remove unused fieled accessors ([d24bcc5](https://github.com/KomMonitor/kommonitor-importer/commit/d24bcc516b030bee6ecf3e7abbe61fabf67b1f35))
- Remove inherited POM declarations ([35b1721](https://github.com/KomMonitor/kommonitor-importer/commit/35b17212bfd0049f6c41930e20614e88e0b8f7e8))
- Remove Character addition in ConverterParameter ([2c44885](https://github.com/KomMonitor/kommonitor-importer/commit/2c44885c9b53f990e650c6fb563f02823909ca7b))
- Remove unused property fetching ([97df854](https://github.com/KomMonitor/kommonitor-importer/commit/97df85456d4e60a9aa3e6d2ce69a8c9f6fc9f7c8))
- Remove hard coded setting ([0270e9c](https://github.com/KomMonitor/kommonitor-importer/commit/0270e9cc53d4ee4eca94cee7dad349a214e95f62))
- Remove default setting of content type header due to invalid duplicate header value when requesting KomMonitor management component ([9734987](https://github.com/KomMonitor/kommonitor-importer/commit/97349871edac387e7d9deb7ca2bee21219acfb5e))

[unreleased]: https://github.com/KomMonitor/kommonitor-importer/compare/4.2.1..HEAD
[4.2.1]: https://github.com/KomMonitor/kommonitor-importer/compare/4.2.0..4.2.1
[4.2.0]: https://github.com/KomMonitor/kommonitor-importer/compare/4.1.1..4.2.0
[4.1.1]: https://github.com/KomMonitor/kommonitor-importer/compare/4.1.0..4.1.1
[4.1.0]: https://github.com/KomMonitor/kommonitor-importer/compare/3.2.5..4.1.0
[3.2.5]: https://github.com/KomMonitor/kommonitor-importer/compare/4.0.0..3.2.5
[4.0.0]: https://github.com/KomMonitor/kommonitor-importer/compare/3.2.4..4.0.0
[3.2.4]: https://github.com/KomMonitor/kommonitor-importer/compare/3.2.3..3.2.4
[3.2.3]: https://github.com/KomMonitor/kommonitor-importer/compare/3.2.2..3.2.3
[3.2.2]: https://github.com/KomMonitor/kommonitor-importer/compare/3.2.1..3.2.2
[3.2.1]: https://github.com/KomMonitor/kommonitor-importer/compare/3.2.0..3.2.1
[3.2.0]: https://github.com/KomMonitor/kommonitor-importer/compare/3.1.1..3.2.0
[3.1.1]: https://github.com/KomMonitor/kommonitor-importer/compare/3.1.0..3.1.1
[3.1.0]: https://github.com/KomMonitor/kommonitor-importer/compare/3.0.0..3.1.0
[3.0.0]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.7..3.0.0
[2.0.7]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.6..2.0.7
[2.0.6]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.5..2.0.6
[2.0.5]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.4..2.0.5
[2.0.4]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.3..2.0.4
[2.0.3]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.2..2.0.3
[2.0.2]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.1..2.0.2
[2.0.1]: https://github.com/KomMonitor/kommonitor-importer/compare/2.0.0..2.0.1
[2.0.0]: https://github.com/KomMonitor/kommonitor-importer/compare/1.2.2..2.0.0
[1.2.2]: https://github.com/KomMonitor/kommonitor-importer/compare/1.2.1..1.2.2
[1.2.1]: https://github.com/KomMonitor/kommonitor-importer/compare/1.2.0..1.2.1
[1.2.0]: https://github.com/KomMonitor/kommonitor-importer/compare/1.0.0..1.2.0
[1.0.0]: https://github.com/KomMonitor/kommonitor-importer/compare/4.2.1..1.0.0

<!-- generated by git-cliff -->
