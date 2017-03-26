var gulp = require('gulp');
var concat = require('gulp-concat');
var watch = require('gulp-watch');
var imagemin = require('gulp-imagemin');
var uglify = require('gulp-uglify');
var babel = require('gulp-babel');
var uglifycss = require('gulp-uglifycss');

var paths = {
  scripts: 'app/js/*.js',
  images: 'app/img/**'
};

gulp.task('scripts', function() {
  return gulp.src(paths.scripts)
    .pipe(concat('script.main.js'))
    .pipe(babel({
      presets: ['es2015']
      }))
    .pipe(uglify())
    .pipe(gulp.dest('dist/scripts/'));
});

gulp.task('css', function() {
  return gulp.src(['app/css/*.css', '!app/css/styles.main.css'])
    .pipe(concat('styles.main.css'))
    .pipe(uglifycss({
      "maxLineLen": 80,
      "uglyComments": true
   }))
    .pipe(gulp.dest('dist/styles/'));
});

gulp.task('images', function() {
   return gulp.src('app/img/**')
      .pipe(imagemin())
      .pipe(gulp.dest('dist/images'));
});

gulp.task('default', ['css', 'scripts']);
